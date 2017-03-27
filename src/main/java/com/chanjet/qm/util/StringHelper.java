package com.chanjet.qm.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

public final class StringHelper {

    public static String generateUrl(String base, Map<String, Object> params, String datePattern) {
        StringBuffer sb = new StringBuffer();
        if (base == null) base = "";
        if (params == null) return base;
        sb.append(base).append("?");
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof List) {
                List list = (List) value;
                for (Object obj : list) {
                    if (obj != null) {
                        if (sb.toString().endsWith("?")) {
                            sb.append(entry.getKey()).append("=").append(convertToString(obj, datePattern));
                        } else {
                            sb.append("&").append(entry.getKey()).append("=").append(convertToString(obj, datePattern));
                        }
                    }
                }
            } else {
                if (sb.toString().endsWith("?")) {
                    sb.append(entry.getKey()).append("=").append(convertToString(entry.getValue(), datePattern));
                } else {
                    sb.append("&").append(entry.getKey()).append("=").append(convertToString(entry.getValue(), datePattern));
                }
            }
        }
        if (sb.toString().endsWith("?")) {
            return sb.toString().substring(0, sb.toString().length() - 1);
        }
        return sb.toString();
    }

    private static String convertToString(Object value, String datePattern) {
        if (value instanceof Date) {
            return DateUtils.getFormattedDateUtil((Date) value, datePattern);
        } else if (value instanceof Number) {
            return value.toString();
        } else if (value instanceof String) {
            return value.toString();
        } else if (value instanceof Boolean) {
            if (Boolean.TRUE.equals(value)) {
                return "true";
            } else if (Boolean.FALSE.equals(value)) {
                return "false";
            } else {
                return "";
            }
        } else if (value instanceof Enum) {
            return String.valueOf(value);
        } else {
            return "";
        }
    }
}
