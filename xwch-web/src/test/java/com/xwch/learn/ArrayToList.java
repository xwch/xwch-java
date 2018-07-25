package com.xwch.learn;

import com.google.common.primitives.Ints;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 数组转列表
 * Created by yfzx-gz-xiewc on 2018/6/12.
 */
public class ArrayToList {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(new String[]{"a","b"}));
        System.out.println(Arrays.asList(new Integer[]{1,2}));
        System.out.println(Arrays.asList(new int[]{1,2}));
        System.out.println(Arrays.asList(new String[]{"a","b"},"c"));
        int[] ints = {1,2,3,4};
        /*guava int[] to List<Integer>*/
        List<Integer> list = Ints.asList(ints);
        /*commons lang3 int[] to Integer[] Object */
        Integer[] Integers = ArrayUtils.toObject(ints);

        System.out.println(list);
        System.out.println(Integers);
    }
}
