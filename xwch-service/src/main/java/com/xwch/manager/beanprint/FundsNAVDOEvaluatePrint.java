package com.xwch.manager.beanprint;

import com.xwch.base.bean.FundsNAVDO;
import com.xwch.utils.NumberUtil;
import com.xwch.utils.StringUtil;

/**
 * 估算值详情输出控制类
 * Created by yfzx-gz-xiewc on 2017/8/15.
 */
public class FundsNAVDOEvaluatePrint {

    private FundsNAVDOEvaluatePrint(){}

    /**
     * 估算值今日涨幅
     */
    public static void getFundsGszzl(FundsNAVDO fundsNAVDO){
        System.out.println("基金：" + StringUtil.stringWithBlankBehind(25,fundsNAVDO.getName()) + ", 估算涨幅：" + fundsNAVDO.getGszzl());
    }

    /**
     * 基金持有收益
     * @param portion 份额
     * @param principal 本金(元)
     * @param fundsNAVDO 基金信息
     */
    public static void getFundsIncome(Double portion,Double principal, FundsNAVDO fundsNAVDO){
        String fundName = StringUtil.stringWithBlankBehind(20,fundsNAVDO.getName());
        //总金额（元）
        double amount = portion * StringUtil.parseDouble(fundsNAVDO.getGsz());

        //持有收益（元）
        double income = amount - principal;
        //卖出手续费
        double fee = amount * 0.005;
        //收益率（%）
        double rate = income * 100 / principal;
        System.out.println("基金：(" +fundsNAVDO.getFundcode()+")"+fundName
                + ", 持有金额：" + NumberUtil.doubleWithRound(amount,2)
                + ", 持有收益：" + NumberUtil.doubleWithRound(income,2)
                + ", 估算收益率：" + NumberUtil.doubleWithRound(rate,2)
                + ", 手续费：" + NumberUtil.doubleWithRound(fee,2)
                + ", 实际收益（估算收益-手续费）：" + NumberUtil.doubleWithRound(income - fee, 2)
                + ", 今日涨幅(%)：" + fundsNAVDO.getGszzl()
                + ", 今日涨跌(元)：" + NumberUtil.doubleWithRound((Double.parseDouble(fundsNAVDO.getGsz())-Double.parseDouble(fundsNAVDO.getDwjz())) * portion,2)
                + ", 估值时间：" + fundsNAVDO.getGztime()
        );
    }
}
