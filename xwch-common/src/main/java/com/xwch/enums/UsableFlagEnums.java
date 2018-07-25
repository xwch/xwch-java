package com.xwch.enums;


import lombok.*;

/**
 * Created by xwch on 2017/6/15.
 */
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public enum UsableFlagEnums {

    /**
     * 有效
     */
    USABLE("USABLE"),
    /**
     * 无效
     */
    UN_USABLE("UN_USABLE");

    private String usableFlag;
}
