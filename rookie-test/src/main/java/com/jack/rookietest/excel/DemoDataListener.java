package com.jack.rookietest.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * @Classname DemoDataListener
 * Create by jack 2020/1/5
 * @date: 2020/1/5 11:35
 * @Description:
 * 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
 */
public class DemoDataListener extends AnalysisEventListener<DemoData> {
    List<DemoData> list = new ArrayList<DemoData>();

    /**
     * 个每一条数据解析都会来调用
     * @param demoData
     * @param analysisContext
     */
    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        System.out.println(demoData);
    }

    /**
     * 所有数据解析完成了 都会来调用
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("excel解析完成");
    }
}
