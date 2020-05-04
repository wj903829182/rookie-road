package com.jack.rookiepractice.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jack
 * @Classname EasyExcelTest1
 * Create by jack 2020/5/3
 * @date: 2020/5/3 11:06
 * @Description:
 * https://www.yuque.com/easyexcel/doc/write
 *
 *
 */
public class EasyExcelTest1 {

    /**
     * 创建excel数据
     *
     * @return
     */
    public static List<EasyExcelMode> createModelList() {
        List<EasyExcelMode> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            EasyExcelMode excelMode = new EasyExcelMode();
            excelMode.setUserName("哒哒" + i);
            excelMode.setAge("22");
            excelMode.setAddress("广西");
            list.add(excelMode);
        }
        return list;
    }

    public static List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    public static void exportTest1()  {
        // 写法1
        String fileName = "F:\\mystudy\\"+ "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        //EasyExcel.write(fileName, EasyExcelMode.class).sheet("模板").doWrite(createModelList());
        ExcelWriterSheetBuilder sheetBuilder = EasyExcel.write(fileName, EasyExcelMode.class).sheet("模板");
        sheetBuilder.doWrite(createModelList());

    }


    public static void exportTest2()  {
        // 写法2
        String fileName = "F:\\mystudy\\"+ "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName, EasyExcelMode.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        excelWriter.write(createModelList(), writeSheet);
        excelWriter.write(createModelList(), writeSheet);
        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();

    }

    public static void exportTest3(){
        String fileName = "F:\\mystudy\\"+ "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        EasyExcel.write(fileName, ConverterData.class).sheet("模板").doWrite(data());
    }

    public static void main(String[] args) {
        //exportTest1();
        //exportTest2();
        exportTest3();
        System.out.println("********end*********");
    }
}
