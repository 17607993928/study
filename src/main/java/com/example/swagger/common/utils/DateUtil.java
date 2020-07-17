package com.example.swagger.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @类描述:时间处理工具
 * @创建人:xiejs
 * @创建时间:2020-7-15 09:51:26
 */
public class DateUtil {
    public static final String DATE_FORMAT_YYYYMMDD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_TIME_H = "yyyy-MM-dd HH";
    public static final String DATE_FORMAT_TIME_R = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_TIME_T = "yyyy-MM-dd HH:mm:ss";
    public static final String DB_TIME_PATTERN = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_YYYYMMDD_TWO = "yyyyMMdd";
    public static final String DATE_FORMAT_YYYYMMDD_THREE = "yyyy/MM/dd";
    public static final String DATE_FORMAT_HMS = "HHmmss";
    public static final String DATE_FORMAT_HMS2 = "HH:mm:ss";
    public static final String DATE_FORMAT_YYYYMM = "yyyymm";
    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";

    public DateUtil() {
    }


    public static String timeStampToDateString(Long seconds, String format) {
        if (seconds == null) {
            return null;
        } else {
            if (format == null || format.isEmpty()) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(format);
            if (seconds.toString().length() != 13) {
                seconds = Long.valueOf(seconds + "000");
            }

            return sdf.format(new Date(seconds));
        }
    }

    public static Long dateToTimeStamp(String dateStr, String format) {
        try {
            if (format == null || format.isEmpty()) {
                format = "yyyy-MM-dd HH:mm:ss";
            }

            if (dateStr != null && !dateStr.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                return sdf.parse(dateStr).getTime() / 1000L;
            } else {
                return null;
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Long dateToTimeStamp(String dateStr) {
        return dateToTimeStamp(dateStr, (String) null);
    }

    public static Long dateToTimeStamp(Date date) {
        return date != null ? date.getTime() / 1000L : null;
    }

    public static Long timeStamp() {
        return System.currentTimeMillis() / 1000L;
    }

    public static Date timeStampToDate(Long timeStamp) {
        try {
            String dateStr = timeStampToDateString(timeStamp, (String) null);
            return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(dateStr);
        } catch (ParseException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public static String dateToString(Date date, String format) {
        try {
            if (format == null || format.isEmpty()) {
                format = "yyyy-MM-dd";
            }

            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static Date StringToDate(String dateStr, String format) {
        try {
            if (format == null || format.isEmpty()) {
                format = "yyyy-MM-dd";
            }

            if (dateStr != null && !dateStr.isEmpty()) {
                DateFormat dateFormat = new SimpleDateFormat(format);
                return dateFormat.parse(dateStr);
            } else {
                return null;
            }
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    /**
     * 预设不同的时间格式
     */
    //精确到年月日（英文） eg:2019-12-31
    public static String FORMAT_LONOGRAM = "yyyy-MM-dd";
    //精确到时分秒的完整时间（英文） eg:2010-11-11 12:12:12
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
    //精确到毫秒完整时间（英文） eg:2019-11-11 12:12:12.55
    public static String FORMAT_LONOGRAM_MILL = "yyyy-MM-dd HH:mm:ss.SSS";
    //精确到年月日（中文）eg:2019年11月11日
    public static String FORMAT_LONOGRAM_CN = "yyyy年MM月dd日";
    //精确到时分秒的完整时间（中文）eg:2019年11月11日 12时12分12秒
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日 HH时MM分SS秒";
    //精确到毫秒完整时间（中文）
    public static String FORMAT_LONOGRAM_MILL_CN = "yyyy年MM月dd日HH时MM分SS秒SSS毫秒";

    /**
     * 预设默认的时间格式
     */
    public static String getDefaultFormat() {
        return FORMAT_FULL;
    }

    /**
     * 预设格式格式化日期
     */
    public static String format(Date date) {
        return format(date, getDefaultFormat());
    }

    /**
     * 自定义格式格式化日期
     */
    private static String format(Date date, String format) {
        String value = "";
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            value = sdf.format(date);
        }
        return value;
    }

    /**
     * 根据预设默认格式，返回当前日期
     */
    public static String getNow() {
        return format(new Date());
    }

    /**
     * 自定义时间格式，返回当前日期
     */
    public static String getNow(String format) {
        return format(new Date(), format);
    }

    /**
     * 根据预设默认时间 String->Date
     */
    public static Date parse(String strDate) {
        return parse(strDate, getDefaultFormat());
    }

    /**
     * 自定义时间格式：Stirng->Date
     */
    public static Date parse(String strDate, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 基于指定日期增加年
     * @param num 正数往后推，负数往前移
     *            Calendar:它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR
     *            等日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
     */
    public static Date addYear(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, num);
        return cal.getTime();
    }

    /**
     * 基于指定日期增加整月
     * @param date
     * @param num  整数往后推，负数往前移
     * @return
     */
    public static Date addMonth(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, num);
        return cal.getTime();
    }

    /**
     * 基于指定日期增加天数
     * @param date
     * @param num  整数往后推，负数往前移
     * @return
     */
    public static Date addDay(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, num);
        return cal.getTime();
    }

    /**
     * 基于指定日期增加分钟
     * @param date
     * @param num  整数往后推，负数往前移
     * @return
     */
    public static Date addMinute(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, num);
        return cal.getTime();
    }

    /**
     * 获取时间戳 eg:yyyy-MM-dd HH:mm:ss.S
     * @return
     */
    public static String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_LONOGRAM_MILL);
        Calendar cal = Calendar.getInstance();
        return sdf.format(cal.getTime());
    }

    /**
     * 获取日期的年份
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        return format(date).substring(0, 4);
    }

    /**
     * 获取年份+月
     */
    public static String getYearMonth(Date date) {
        return format(date).substring(0, 7);
    }

    /**
     * 获取日期的小时数
     */
    public static int getHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 自定义时间格式字符串距离今天的天数
     * @param strDate
     * @param format
     * @return
     */
    public static int countDays(String strDate, String format) {
        long time = Calendar.getInstance().getTime().getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse(strDate, format));
        long diff = cal.getTime().getTime();
        long a = time / 1000;
        long b = diff / 1000;
        return (int) (a - b) / 3600 / 24;
    }

    /**
     * 预设格式的字符串距离今天的天数
     * @param strDate
     * @return
     */
    public static int countDays(String strDate) {
        return countDays(strDate, getDefaultFormat());
    }

    /**
     * 获取天数差值(依赖时间)
     * @param date1
     * @param date2
     * @return
     */
    public static int diffDays(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return 0;
        }
        return (int) (Math.abs(date1.getTime() - date2.getTime()) / (60 * 60 * 24 * 1000));
    }

    /**
     * 获取年份差值
     * @param year1
     * @param year2
     * @return
     */
    public static int diffYear(Date year1, Date year2) {
        return diffDays(year1, year2) / 365;
    }

    /**
     * 获取天数差值(依赖Date类型的日期)
     * @param d1
     * @param d2
     * @return
     */
    public static int diffByDays(Date d1, Date d2) {
        Date s1 = parse(format(d1, FORMAT_LONOGRAM), FORMAT_LONOGRAM);
        Date s2 = parse(format(d2, FORMAT_LONOGRAM), FORMAT_LONOGRAM);
        return diffDays(s1, s2);
    }

    /**
     * 获取时间分割集合
     * @param date 查询日期
     * @param strs 带拆分的时间点
     * @return
     */
    public static List<Date> collectTimes(Date date, String[] strs) {
        List<Date> result = new ArrayList();
        List<String> times = Arrays.asList(strs);
        String dateStr = format(date, FORMAT_LONOGRAM);
        String pattern = FORMAT_LONOGRAM + "K";
        if (times.size() > 0) {
            times.stream().forEach(t -> {
                result.add(parse(date + " " + t, pattern));
            });
        }
        return result;
    }

    /**
     * 根据日期查询当前为周几
     * @param dt
     * @return
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK);   //1--7的值,对应：星期日，星期一，星期二，星期三....星期六
        //System.out.println(w);
        return weekDays[w - 1];

    }

    /**
     * 将时间转换成汉字
     * @param hour
     * @return
     */
    public static String hourToCn(String hour) {
        String[] timeArray = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
        String[] hourArray = hour.split(":");
        int hourInt = Integer.parseInt(hourArray[0]);
        int minute = Integer.parseInt(hourArray[1]);
        String result = intToCn(hourInt, timeArray) + "点\n" + intToCn(minute, timeArray) + "分";
        return result;
    }

    private static String intToCn(int hourInt, String[] timeArray) {
        String result = "";
        if (hourInt >= 0 && hourInt <= 10) {
            result += timeArray[hourInt] + "\n";
        } else if (hourInt >= 11 && hourInt <= 19) {
            result += (timeArray[10] + "\n" + timeArray[hourInt % 10]) + "\n";
        } else {
            result += (timeArray[hourInt / 10] + "\n" + timeArray[10]) + "\n" + (hourInt % 10 == 0 ? "" : timeArray[hourInt % 10] + "\n");
        }
        return result;
    }

    /**
     * 获取当前日期后的一周时间，并返回LinkedHashMap<String, Date>
     * @param startTime
     * @return
     */
    public static LinkedHashMap<String, Date> dateAfterWeek(String startTime) {
        LinkedHashMap<String, Date> result = new LinkedHashMap<>();
        try {
            Date date = parse(startTime, FORMAT_LONOGRAM);
            for (int i = 0; i < 7; i++) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(calendar.DATE, i);  //把日期往后增加一天,整数往后推,负数往前移动  时间戳转时间
                Date newDate = calendar.getTime();
                String str = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
                result.put(str, newDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 获取当前日期 后的一周时间，并返回yyyy-MM-dd字符串数组
     * @param startTime
     * @return
     */
    public static String[] dateAfterWeekArray(String startTime) {
        String weekArray[] = new String[7];
        try {
            Date date = parse(startTime, FORMAT_LONOGRAM);
            for (int i = 0; i < 7; i++) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(calendar.DATE, i);//把日期往后增加一天,整数往后推,负数往前移动  时间戳转时间
                Date newDate = calendar.getTime();
                weekArray[i] = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weekArray;
    }

    /**
     * 根据传入的时间获取本周开始（0-表示本周，1-表示下周，-1-表示上周  ）
     * @param date
     * @return
     */
    public static String getMonDayToDate(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parse(date, "yyyy-MM-dd"));
        // N：0-表示本周，1-表示下周，-1-表示上周
        cal.add(Calendar.DATE, 0 * 7);
        // Calendar.MONDAY 表示获取周一的日期; Calendar.WEDNESDAY:表示周三的日期
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return format(cal.getTime());
    }

    /**
     * @param date
     * @return
     * @Title: getDateSencond
     * @Description: 将日期转换为毫秒数
     */
    public static long getDateSencond(Date date) {
        long millionSeconds;
        millionSeconds = date.getTime();
        return millionSeconds;
    }

    private final static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
    /***
     *
     * @Title: getCurrentWeekDay
     * @Description: 获取本周周一
     */
    public static String getCurrentMonday(){
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
        cal.add(Calendar.DATE, 0);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        String monday = sdf.format(cal.getTime());
        return monday;
    }
    /***
     *
     * @Title: getPreviousSunday
     * @Description: 获取上周周日
     */
    public static String getPreviousSunday(){
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
        cal.add(Calendar.DATE, -1*7);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        String sunday =sdf.format(cal.getTime());
        return sunday;
    }

    public static void main(String[] args) {

    }


}
