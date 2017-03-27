package com.chanjet.qm.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 */
public class DateUtils {


    private static final SimpleDateFormat formatterUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+08:00");
    public static synchronized String getUTCString(Date date) {
        String formatDate = formatterUTC.format(date);
        return formatDate;
    }

    /**
     * 将一个字符串转化成日期对象，如果转化失败，返回null
     *
     * @param sourceString
     * @param pattern
     * @return
     */
    public static Date parseDateFromString(String sourceString, String pattern) {
        Date re = null;

        if (sourceString != null && !sourceString.equals("")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            try {
                re = dateFormat.parse(sourceString);
            } catch (ParseException e) {
                return null;
            }
        }

        return re;
    }


    public static String get24TimeString(Time time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formatDate = dateFormat.format(time);
        return formatDate;
    }

    public static Time from24TimeString(String src){
        return Time.valueOf(src);
    }


    public static String getFormattedDateUtil(Date dtDate, String strFormatTo) {
        if (dtDate == null) {
            return "";
        }
        strFormatTo = strFormatTo.replace('/', '-');
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(strFormatTo);
            return formatter.format(dtDate);
        } catch (Exception e) {
            return "";
        }
    }



}
