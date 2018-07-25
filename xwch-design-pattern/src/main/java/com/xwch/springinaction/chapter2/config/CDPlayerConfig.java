package com.xwch.springinaction.chapter2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * CDPlayer配置类,默认扫描与配置类相同的包下的注解类
 * Created by yfzx-gz-xiewc on 2017/7/21.
 */
@Configuration  //表明是配置类
@ComponentScan(value = "com.xwch.springinaction.chapter2") //该注解在Spring中启用组建扫描
public class CDPlayerConfig {
}
