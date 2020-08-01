package com.jack.common.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * create by jack 2019/11/27
 *
 * @author jack
 * @date: 2019/11/27 20:54
 * @Description:
 * LocalDateTime的封装
 * 组合了日期和时间，但不包含时差和时区信息
 */
public final class LocalDateTimeUtils {
    public static final String FORMAT_ONE = "yyyy-MM-dd";
    public static final String FORMAT_TWO = "yyyyMMddHHmmss";
    public static final String FORMAT_THREE = "yyyyMMdd HH:mm:ss";
    public static final String FORMAT_FOUR = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_FIVE = "yyyy/MM/dd HH:mm:ss";
    public static final String FORMAT_SIX = "yyyyMMdd";
    private static final String MINUS = "-";

    private LocalDateTimeUtils() {
    }

    public static LocalDateTime nowLocalDateTime(){
        return LocalDateTime.now();
    }

    /**
     * 获取当前时间的秒数
     * @return
     */
    public static long nowLocalDateTimeSecond(){
        return LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
    }

    /**
     * 获取时区当前时间的毫秒数
     * @return
     */
    public static long nowLocalDateTimeMillisecond(){
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 获取当前时间指定格式的字符串
     * @param pattern
     * @return
     */
    public static String nowLocalDateTimeToStr(String pattern){
        //时间转字符串格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.now().format(formatter);
    }

    /**
     * 时间字符串转换为LocalDateTime
     * @param localDateTimeStr
     * @param pattern
     * @return
     */
    public static LocalDateTime StrToLocalDateTime(String localDateTimeStr,String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(localDateTimeStr, formatter);
    }


    /**
     * LocalDateTime转换为指定格式的字符串
     * @param localDateTime
     * @param pattern
     * @return
     */
    public static String localDateTimeToStr(LocalDateTime localDateTime,String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }

    /**
     * Date转换为指定格式的字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String localDateTimeToStr(Date date,String pattern){
        LocalDateTime localDateTime =  dateConvertToLocalDateTime(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }

    /**
     * 解析字符串日期为Date
     * @param dateStr 日期字符串
     * @param pattern 格式
     * @return Date
     */
    public static Date parseDateStr(String dateStr, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }


    /**
     * 将java.util.Date 转换为java8 的java.time.LocalDateTime,默认时区为东8区
     * @param date
     * @return
     */
    public static LocalDateTime dateConvertToLocalDateTime(Date date) {
        return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
    }



    /**
     * 将java8 的 java.time.LocalDateTime 转换为 java.util.Date，默认时区为东8区
     * @param localDateTime
     * @return
     */
    public static Date localDateTimeConvertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
    }


    public static void main(String[] args) {
//        System.out.println(nowLocalDateTimeMillisecond());
//        System.out.println(System.currentTimeMillis());
//        System.out.println(nowLocalDateTimeToStr(FORMAT_FOUR));
        System.out.println(StrToLocalDateTime("2020-08-01 16:52:56",FORMAT_FOUR));
    }
}
