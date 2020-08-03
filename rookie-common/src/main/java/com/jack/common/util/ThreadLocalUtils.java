package com.jack.common.util;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Jack
 * @ClassName ThreadLocalUtils
 * Created By Jack on 2020/8/3
 * @date 2020/8/3 20:03
 * @Description:
 * ThreadLocal工具类
 */
public class ThreadLocalUtils {
    /**
     * 采用TTL的实现
     */
    private static final ThreadLocal<Map<String, Object>> TTL = new TransmittableThreadLocal<>();

    private ThreadLocalUtils() {
    }

    /**
     * 存储
     * @param key
     * @param value
     */
    public static void set(String key,Object value) {
        if (Objects.nonNull(key)){
            Map<String, Object> map = TTL.get();
            if (map == null) {
                map = new HashMap<>(16);
                TTL.set(map);
            }
            TTL.get().put(key, value);
        }


    }

    /**
     * 取值
     * @param key
     * @param <T>
     * @return
     */
    public static  <T> T get(String key) {
        Map<String, Object> map = TTL.get();
        if (map != null) {
            return (T) map.get(key);
        }
        return null;
    }

    public static <T> T get(String key,T defaultValue) {
        Map map = TTL.get();
        return map.get(key) == null ? defaultValue : (T)map.get(key);
    }

    public static void clear() {
        Map<String, Object> map = TTL.get();
        if (map != null) {
            map.clear();
        }
        TTL.remove();
    }

    public static <T> T remove(String key) {
        Map map = TTL.get();
        return (T)map.remove(key);
    }
}
