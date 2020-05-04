package com.jack.rookiepractice.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author jack
 * @Classname EasyExcelMode
 * Create by jack 2020/5/3
 * @date: 2020/5/3 11:04
 * @Description:
 */
@Data
public class EasyExcelMode {
    @ExcelProperty(value = "姓名" ,index = 0)
    private  String  userName;
    @ExcelProperty(value = "年龄" ,index = 1)
    private String age;
    @ExcelProperty(value = "住址" ,index = 2)
    private String address;
}
