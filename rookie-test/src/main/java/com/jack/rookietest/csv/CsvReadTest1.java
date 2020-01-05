package com.jack.rookietest.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @author jack
 * @Classname CsvReadTest1
 * Create by jack 2020/1/5
 * @date: 2020/1/5 12:06
 * @Description:
 */
public class CsvReadTest1 {
    public static void main(String[] args) {
        String fileUlr = "F:\\20191226-YUBINMST7_mon1.csv";
        try {
            //先FileReader把文件读出来再bufferReader按行读  reader.readLine(); 没有标题用不着了
            //BufferedReader reader = new BufferedReader(new FileReader(fileUlr));
            InputStreamReader inputStreamReader = new InputStreamReader( new FileInputStream(fileUlr),"UTF-8");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = null;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                //一行数组
                String item[] = line.split(",");
                System.out.println("line="+line);
                System.out.println("item="+item);
                index++;
                if (index > 10) {
                    break;
                }
            }
        } catch (Exception e) {
            //在命令行打印异常信息在程序中出错的位置及原因。
            e.printStackTrace();
        }

    }
}
