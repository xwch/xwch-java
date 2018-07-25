package com.xwch.base;

/**
 * Created by yfzx-gz-xiewc on 2018/4/13.
 */
public class CompareToTest {

    public static void main(String[] args) {
        Long firstNum = 1000000000000L;
        Long secondNum = 1000000000000L;
        CompareToTest.longCompareTo(firstNum,secondNum);
        CompareToTest.longEquals(firstNum,secondNum);
    }



    private static void longCompareTo(Long firstNum,Long secondNum){
        if (firstNum.compareTo(secondNum) == 0){
            System.out.println("longCompareTo:"+firstNum+"等于"+secondNum);
            return;
        }
        System.out.println("longCompareTo:"+firstNum+"不等于"+secondNum);
    }

    private static void longEquals(Long firstNum,Long secondNum){
        if (firstNum.equals(secondNum)){
            System.out.println("longEquals:"+firstNum+"等于"+secondNum);
            return;
        }
        System.out.println("longEquals:"+firstNum+"不等于"+secondNum);
    }
}
