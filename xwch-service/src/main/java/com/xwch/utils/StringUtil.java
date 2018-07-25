package com.xwch.utils;

import org.apache.commons.lang.StringUtils;

/**
 * 字符串工具类
 * Created by yfzx-gz-xiewc on 2017/8/15.
 */
public class StringUtil {
    private StringUtil(){}

    /**
     * string后面补空格，限定返回的string长度
     * @param length 返回的string长度
     * @param value 传入的string值
     * @return 返回限定长度的string
     */
    public static String stringWithBlankBehind(int length, String value){
        int valueLength = value.length();
        if (length > valueLength){
            for (int i = 0; i < length-valueLength; i++) {
                value += "-";
            }
        }
        return value;
    }

    /**
     * 将字符串转为数字
     * @param value 字符串数字
     * @return Double类型
     */
    public static Double parseDouble(String value){
        if (value.contains(".")){
            return Double.parseDouble(String.format("%s%s", StringUtils.substringBefore(value, ".")
                    , StringUtils.substringAfterLast(value, ".")))
                    / Math.pow(10,StringUtils.substringAfterLast(value, ".").length());
        }
        return 0.0;
    }
}
