package com.xwch.learn;

/**
 * Created by yfzx-gz-xiewc on 2018/6/19.
 */
public class CharTest {

    public static void main(String[] args) {

        String className = new CharTest().getClass().getSimpleName();
        System.out.println(className);
        char string = (char)(2+'0');
        System.out.println(string);
        String seq="1233313";
        String result = appendSeq(seq,2*10000);
        System.out.println(result);
    }


    protected static String appendSeq(String seqLowLimit, int delta){
        int cf = 0, num, index = 0, length = seqLowLimit.length();
        char[] resCharArray = new char[seqLowLimit.length()];
        seqLowLimit.getChars(0, seqLowLimit.length(), resCharArray, 0);
        while (delta != 0){
            //个位数
            num = delta % 10;
            //值相加
            int cNum = resCharArray[length - 1 - index] - '0' + num + cf;
            //超过10的，十位数要加到下一位
            cf = cNum / 10;
            //下一次处理位数
            delta /= 10;
            //
            resCharArray[length - 1 - index++] = (char) (cNum % 10 + '0');
        }
        //如果处理完最左一位，发现要进位
        while(cf != 0 && index < length){
            int cNum = resCharArray[length - 1 - index] - '0' + cf;
            cf = cNum / 10;
            resCharArray[length - 1 - index++] = (char) (cNum % 10 + '0');
        }
        if (index >= length && cf != 0){
            //log.error(TAG  +"处理序列号异常，序列号数值递增发生溢出");
            throw new RuntimeException("处理序列号异常，序列号数值递增发生溢出");
        }
        return new StringBuilder().append(resCharArray).toString();
    }
}
