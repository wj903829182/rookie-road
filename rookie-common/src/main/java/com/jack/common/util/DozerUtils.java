package com.jack.common.util;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack
 * @ClassName DozerUtils
 * Created By Jack on 2020/8/4
 * @date 2020/8/4 11:24
 * @Description:
 * Dozer 是一个对象转换工具
 * Dozer可以在JavaBean到JavaBean之间进行递归数据复制,并且这些JavaBean可以是不同的复杂的类型。
 * 所有的mapping，Dozer将会很直接的将名称相同的fields进行复制，如果field名不同，或者有特别的对应要求，则可以在xml中进行定义。
 */
public class DozerUtils {
    private static Mapper mapper = new DozerBeanMapper();

    public static <T> List<T> transforList(List<?> sources, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        if (sources == null) {
            return list;
        }
        for (Object o : sources) {
            T t = transfor(o, clazz);
            list.add(t);
        }
        return list;
    }

    /**
     * 从source拷贝到target
     * @param source
     * @param target
     */
    public static void transfor(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        mapper.map(source, target);
    }

    /**
     * 从source拷贝到目标类
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T> T transfor(Object source, Class<T> target) {
        if (source == null) {
            return null;
        }
        return mapper.map(source, target);
    }

}
