package com.xwch.base.service;

import com.xwch.base.bean.AddressDAO;

/**
 * Created by yfzx-gz-xiewc on 2017/6/15.
 */
public interface AddressManager {

    AddressDAO queryAddressInfoByReceiver(String receiver);
}
