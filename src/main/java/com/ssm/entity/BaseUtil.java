package com.ssm.entity;

public class BaseUtil {
    public static int transObjectToInt(Object obj) {
        int info = 0;
        if (obj != null && !obj.equals("")) {
            info = Integer.parseInt(obj.toString());
        }
        return info;
    }

    //将对象转换成字符串
    public static String transObjectToString(Object obj) {
        if (obj != null && !obj.equals("")) {
            return obj.toString();
        }
        return "";
    }

    public static boolean checkNotNull(Object obj) {
        if (obj != null && !obj.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public static String transArrayToString(Object[] objs) {
        StringBuffer str = new StringBuffer("");
        if (objs != null) {
            for (Object obj : objs) {
                str.append(obj.toString() + ",");
            }
        }
        return str.substring(0, str.length() - 1);
    }
}
