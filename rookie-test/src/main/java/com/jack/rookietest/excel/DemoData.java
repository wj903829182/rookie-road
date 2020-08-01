package com.jack.rookietest.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author jack
 * @Classname DemoData
 * Create by jack 2020/1/5
 * @date: 2020/1/5 11:30
 * @Description:
 * 对应excel每一行的数据
 *@ExcelProperty的index属性对应excle的列，列从0开始
 */
@Data
public class DemoData{
    @ExcelProperty(index = 0)
    private String column1;
    @ExcelProperty(index = 19)
    private String column2;
    @ExcelProperty(index = 20)
    private String column3;
}
