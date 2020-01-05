package com.jack.rookietest.excel;

import com.alibaba.excel.EasyExcel;

import java.io.File;

/**
 * @author jack
 * @Classname ReadExcelTest1
 * Create by jack 2020/1/5
 * @date: 2020/1/5 11:25
 * @Description:
 * 读取EXCEL测试1
 * 参考资料：
 * https://github.com/alibaba/easyexcel/blob/master/src/test/java/com/alibaba/easyexcel/test/demo/read/ReadTest.java
 */
public class ReadExcelTest1 {

    public static void main(String[] args) {
        // 写法1：
        String fileUrl1 = "F:\\20191226-YUBINMST7_mon1.xlsx";
        File file = new File(fileUrl1);
        //写法1：
        // 这里 需要指定读用哪个class去读，然后读取第二个sheet 文件流会自动关闭
        //EasyExcel.read(file, DemoData.class, new DemoDataListener()).sheet(1).doRead();
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭, headRowNumber这里可以设置1，因为头就是一行。如果多行头，可以设置其他值。不传入也可以，因为默认会根据DemoData 来解析，他没有指定头，也就是默认1行
        EasyExcel.read(file, DemoData.class, new DemoDataListener()).sheet().headRowNumber(0).doRead();

        // 写法2：
        //ExcelReader excelReader = EasyExcel.read(file, DemoData.class, new DemoDataListener()).build();
        //读取excel的第一个sheet
        //ReadSheet readSheet = EasyExcel.readSheet(0).build();
        //excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        //excelReader.finish();
    }
}
