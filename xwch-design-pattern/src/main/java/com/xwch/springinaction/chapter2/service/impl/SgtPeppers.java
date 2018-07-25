package com.xwch.springinaction.chapter2.service.impl;

import com.xwch.springinaction.chapter2.service.CompactDisc;
import org.springframework.stereotype.Component;

/**
 * Created by yfzx-gz-xiewc on 2017/7/21.
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    public void play() {
        System.out.println("Playing "+ title + " by " + artist);
    }


}
