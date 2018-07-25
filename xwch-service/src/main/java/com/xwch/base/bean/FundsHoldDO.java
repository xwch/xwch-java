package com.xwch.base.bean;

import lombok.*;

/**
 * 基金持有信息
 * Created by yfzx-gz-xiewc on 2017/8/17.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FundsHoldDO {
    /**
     * 基金代码
     */
    String foundCode;
    /**
     * 持有份额
     */
    Double portion;
    /**
     * 本金（元）
     */
    Double principal;

}
