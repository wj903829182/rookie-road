package com.jack.rookiepractice.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 * @Classname ExcelTest2
 * Create by jack 2020/5/3
 * @date: 2020/5/3 08:40
 * @Description:
 * https://blog.csdn.net/expect521/article/details/81122642
 * https://www.jianshu.com/p/8b86c7a55d0d
 * https://blog.csdn.net/w893932747/article/details/89354979
 */
public class ExcelTest2 {

    /**
     * 创建excel title
     */
    public static String[] excelTitle() {
        String[] strArray = { "学号", "姓名", "年龄", "生日" };
        return strArray;
    }

    /**
     * 初始化数据，将会被存储到excel表格中
     *
     * @return
     * @throws Exception
     */
    private static Map<String, List<String>> getMember() {
        List<Member> list = new ArrayList<Member>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        try {
            Member user1 = new Member(1, "熊大", 24, df.parse("1993-08-28"));
            Member user2 = new Member(2, "熊二", 23, df.parse("1994-08-19"));
            Member user3 = new Member(3, "熊熊", 24, df.parse("1983-11-22"));

            list.add(user1);
            list.add(user2);
            list.add(user3);


            for (int i = 0; i < list.size(); i++) {
                ArrayList<String> members = new ArrayList<String>();
                members.add(list.get(i).getCode() + "");
                members.add(list.get(i).getName());
                members.add(list.get(i).getAge() + "");
                members.add(df.format(list.get(i).getBirth()));
                map.put(list.get(i).getCode() + "", members);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * @功能：手工构建一个简单格式的Excel
     */
    public static void createExcel(Map<String, List<String>> map, String[] strArray) throws IOException {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //XSSFWorkbook wb = new XSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("sheet1");
        // 默认列宽
        sheet.setDefaultColumnWidth(20);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        // 创建一个居中格式
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //style.setAlignment(HorizontalAlignment.CENTER_SELECTION);


        // 添加excel title
        HSSFCell cell = null;
        for (int i = 0; i < strArray.length; i++) {
            cell = row.createCell( i);
            cell.setCellValue(strArray[i]);
            cell.setCellStyle(style);
        }

        // 第五步，写入实体数据 实际应用中这些数据从数据库得到,list中字符串的顺序必须和数组strArray中的顺序一致
        int i = 0;
        for (String str : map.keySet()) {
            row = sheet.createRow((int) i + 1);
            List<String> list = map.get(str);

            // 第四步，创建单元格，并设置值
            for (int j = 0; j < strArray.length; j++) {
                row.createCell(j).setCellValue(list.get(j));
            }


            i++;
        }
        // 第六步，将文件存到指定位置
        try {
            FileOutputStream fout = new FileOutputStream("F:\\mystudy\\Members.xls");
            wb.write(fout);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            wb.close();
        }

    }


    public static void main(String[] args) throws IOException {
        Map<String, List<String>> memberMap = getMember();
        String[] strArray = excelTitle();
        createExcel(memberMap, strArray);

    }
}
