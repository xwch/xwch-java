package com.xwch.base;

import com.xwch.base.service.impl.HelloWorldService;

/**
 * Created by xwch on 2017/5/21.
 */
public class HelloWorld {
    public static void main(String[] args) {
        HelloWorldService.sayHello();
        System.out.println("---->"+HelloWorld.class.getName());
        System.out.println("--->"+HelloWorld.class.getSimpleName());
        new HelloWorld().mathTest();
    }


    /**
     * Math函数，支持类型：double、float、int、long
     */
    private void mathTest(){
        double numOne = 12.10;
        double numTwo = 12.10;

        System.out.println("Math.max---->"+Math.max(numOne,numTwo));

        System.out.println("Math.max---->"+Math.max(-0.0,-0.0));
        //四舍五入：+0.5再向下取整
        System.out.println("Math.round--->"+Math.round(1.5));
        System.out.println("Math.round--->"+Math.round(-1.5));
    }

}
