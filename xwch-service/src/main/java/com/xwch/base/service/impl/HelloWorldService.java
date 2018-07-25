package com.xwch.base.service.impl;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by xwch on 2017/5/21.
 */
@Slf4j
public class HelloWorldService {

    public static void sayHello(){
        System.out.println("hello,I am xwch!");
        StackTraceElement[] stackTrace =Thread.currentThread().getStackTrace();
        log.info("stackTrace-->"+ Arrays.toString(stackTrace));
    }
}
