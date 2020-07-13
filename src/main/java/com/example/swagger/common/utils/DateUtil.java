package com.example.swagger.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
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
        return dateToTimeStamp(dateStr, (String)null);
    }

    public static Long dateToTimeStamp(Date date) {
        return date != null ? date.getTime() / 1000L : null;
    }

    public static Long timeStamp() {
        return System.currentTimeMillis() / 1000L;
    }

    public static Date timeStampToDate(Long timeStamp) {
        try {
            String dateStr = timeStampToDateString(timeStamp, (String)null);
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
}
