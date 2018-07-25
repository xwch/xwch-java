package com.bestpay.bpcs.filepush.common.utils;


import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

/**
 * Created by yfzx-gz-xiewc on 2018/2/7.
 */
public class ObjectUtil {
    private ObjectUtil(){}

    public static Object nullToChooseSecond(Object first,Object second){
        if (null == first){
            return second;
        }
        return first;
    }
}
