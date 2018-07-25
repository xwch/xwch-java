package com.xwch.utils;

/**
 * 数字工具类
 * Created by yfzx-gz-xiewc on 2017/8/15.
 */
public class NumberUtil {
    private NumberUtil(){}


    /**
     * 四舍五入
     * @param value 原始值
     * @param precision  保留的精度（n位小数）
     * @return 结果值
     */
    public static double doubleWithRound(double value ,int precision){
        double number = Math.pow(10,precision);
        return (double)Math.round(value*number)/number;
    }


    public static void main(String[] args) {
        System.out.println("1.2345--->"+doubleWithRound(1.2345,2));
        System.out.println("1.2345--->"+doubleWithRound(1.2345,3));
    }
}
