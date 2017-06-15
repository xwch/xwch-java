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

    USABLE("USABLE"),
    UN_USABLE("UN_USABLE");

    private String usableFlag;
}
