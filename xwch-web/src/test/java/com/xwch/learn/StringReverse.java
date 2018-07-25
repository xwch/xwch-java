package com.xwch.learn;

/**
 * 字符串反转
 * Created by yfzx-gz-xiewc on 2018/5/7.
 */
public class StringReverse {

    public static void main(String[] args) {
        String srcString = "hello";
        System.out.println("before-->"+srcString);
        String result = reverse(srcString);
        System.out.println("after-->"+result);
        String result2 = reverse2(srcString);
        System.out.println("after2-->"+result2);
    }

    /**
     * 字符串反转
     * @param srcString 源字符串
     * @return 反转后的字符串
     */
    private static String reverse(String srcString) {
        if (srcString == null || srcString.length()<=1){
            return srcString;
        }
        //获取字符串长度
        int length = srcString.length();
        //新建一个char数组，长度为字符串长度
        char[] array = new char[length];
        //循环处理，将原字符串后面的字符按顺序放到字符数组里面
        for (int i = 0; i < length; i++) {
            array[i] = srcString.charAt(length-1-i);
        }
        return new String(array);
    }

    /**
     * 递归反转
     * 1、当字符串长度<=1时，返回该字符串
     * 2、当字符串长度>1时，递归(截取第二位开始到最后的字符串str.substring(1))，然后将第一位放到右边str.charAt[0]
     * @param srcString
     * @return
     */
    private static String reverse2(String srcString){
        if (srcString == null || srcString.length()<=1){
            return srcString;
        }
        return reverse2(srcString.substring(1))+ srcString.charAt(0);
    }
}
