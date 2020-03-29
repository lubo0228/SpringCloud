package com.forezp.hi2.dao;

import com.forezp.hi2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
