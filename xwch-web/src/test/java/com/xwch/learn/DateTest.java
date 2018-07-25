package com.xwch.learn;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yfzx-gz-xiewc on 2018/6/19.
 */
public class DateTest {

    public static void main(String[] args) {
        Date[] dateArray = new Date[8];
        System.out.println(Arrays.toString(dateArray));
        Calendar calendar = Calendar.getInstance();
        Date dateTemp = new Date();
        for (int i = 0;i< 8; i++) {
            dateArray[i] = dateTemp;
            calendar.setTime(dateTemp);
            calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)-1);
            dateTemp = calendar.getTime();
        }
        System.out.println(Arrays.toString(dateArray));
    }
}
