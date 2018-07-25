package com.xwch.task;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yfzx-gz-xiewc on 2018/1/30.
 */
public class AppMain {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-quartz.xml");
    }
}
