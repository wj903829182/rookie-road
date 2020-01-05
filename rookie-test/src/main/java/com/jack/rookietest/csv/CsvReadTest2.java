package com.jack.rookietest.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

/**
 * @author jack
 * @Classname CsvReadTest2
 * Create by jack 2020/1/5
 * @date: 2020/1/5 12:16
 * @Description:
 * 官方文档：http://commons.apache.org/proper/commons-csv/user-guide.html
 * 使用apache的csv工具解析csv文件
 *
 *
 * 参考资料：
 * https://www.jianshu.com/p/3eb98254fe0f?tdsourcetag=s_pcqq_aiomsg
 *https://blog.csdn.net/a158123/article/details/82085350
 *
 */
public class CsvReadTest2 {
    public static void main(String[] args) throws IOException {
        String fileUlr = "F:\\20191226-YUBINMST7_mon1.csv";
        //Reader in = new FileReader("path/to/file.csv");
        InputStreamReader inputStreamReader = new InputStreamReader( new FileInputStream(fileUlr),"UTF-8");
        BufferedReader reader = new BufferedReader(inputStreamReader);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(reader);
        int i = 0;
        for (CSVRecord record : records) {
            //System.out.println(record.get(0)+",");
            System.out.println(record.getComment());
            i++;
            /*String lastName = record.get("Last Name");
            String firstName = record.get("First Name");*/
            if (i > 10) {
                break;
            }
        }
    }
}
