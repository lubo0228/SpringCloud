package com.forezp.service;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.forezp.dao.UserDao;
import com.forezp.entity.User;
import com.forezp.feign.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FeignService {

    @Autowired
    SchedualServiceHi schedualServiceHi;
    @Autowired
    UserDao userDao;

    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    public void txlcn() {
        User user = new User();
        user.setLoginName("0");
        user.setLoginPassword("0");
        user.setRoleName("0");
        userDao.save(user);

        schedualServiceHi.execute();

        int i = 0 / 0;
    }
}
