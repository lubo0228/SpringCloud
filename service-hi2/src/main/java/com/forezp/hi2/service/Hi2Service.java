package com.forezp.hi2.service;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.forezp.hi2.dao.UserDao;
import com.forezp.hi2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Hi2Service {

    @Autowired
    private UserDao userDao;

    @TccTransaction(propagation = DTXPropagation.SUPPORTS)
    public void save() {
        User user = new User();
        user.setLoginName("1");
        user.setLoginPassword("1");
        user.setRoleName("1");
        userDao.save(user);
    }
}
