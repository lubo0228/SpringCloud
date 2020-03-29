package com.forezp.hi.service;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.forezp.hi.dao.UserDao;
import com.forezp.hi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HiService {

    @Autowired
    private UserDao userDao;

    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)//分布式事务
    public void save() {
        User user = new User();
        user.setLoginName("1");
        user.setLoginPassword("1");
        user.setRoleName("1");
        userDao.save(user);
    }
}
