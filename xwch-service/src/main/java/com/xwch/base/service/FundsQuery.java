package com.xwch.base.service;

import com.xwch.base.bean.FundsNAVDO;

/**
 * 开放式基金查询
 * Created by yfzx-gz-xiewc on 2017/7/28.
 */
public interface FundsQuery {

    /**
     * 根据基金代码查询基金信息
     * @param fundCode 基金代码
     * @return
     */
    FundsNAVDO query(String fundCode);
}
