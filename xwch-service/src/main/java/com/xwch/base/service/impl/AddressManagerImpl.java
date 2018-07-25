package com.xwch.base.service.impl;

import com.xwch.base.bean.AddressDAO;
import com.xwch.base.bean.AddressDAOExample;
import com.xwch.base.dao.AddressDAOMapper;
import com.xwch.base.service.AddressManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yfzx-gz-xiewc on 2017/6/15.
 */
@Service("addressManagerImpl")
public class AddressManagerImpl implements AddressManager {
    @Autowired
    AddressDAOMapper addressDAOMapper;

    public AddressDAO queryAddressInfoByReceiver(String receiver) {
        AddressDAOExample po = new AddressDAOExample();
/*        if (!receiver.isEmpty()){
            receiver = Constant.SQLLIKE+receiver+Constant.SQLLIKE;
        }*/
        po.or().andReceiverEqualTo(receiver);
        List<AddressDAO> list = addressDAOMapper.selectByExample(po);
        if (list.isEmpty()){
            System.out.println("查询结果为空");
            return null;
        }
        return list.get(0);
    }
}
