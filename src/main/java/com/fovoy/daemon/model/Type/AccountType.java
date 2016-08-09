package com.fovoy.daemon.model.Type;

/**
 * Created by zxz.zhang on 16/8/9.
 */
public enum AccountType {
    /**
     * 1.支付宝2.微信3.工行4.建行5.招行6.中行7.农行8.交行,9农村信用社
     */
    ALIPAY(1),WECHART(2),ICBC(3),CBC(4),CMB(5),BOC(6),ABC(7),CTB(8),CUB(9);
    private int type;
    AccountType(int type) {
        this.type=type;
    }
}
