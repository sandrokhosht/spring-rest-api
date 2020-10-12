package com.sandrokhosht.rest.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandrokhosht.rest.api.model.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByEmail(String email);
    void deleteUserByEmail(String email);
}
