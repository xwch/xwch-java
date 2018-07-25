package com.xwch.base.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**基金实时估值DO
 * Created by yfzx-gz-xiewc on 2017/7/31.
 */
@Getter
@Setter
@ToString
public class FundsNAVDO {
    /**
     * 基金代码
     */
    String fundcode;
    /**
     * 基金名称
     */
    String name;
    /**
     * 净值日期
     */
    String jzrq;
    /**
     * 单位净值
     */
    String dwjz;
    /**
     * 估算值
     */
    String gsz;
    /**
     * 估算值涨幅
     */
    String gszzl;
    /**
     * 估值时间
     */
    String gztime;
}
