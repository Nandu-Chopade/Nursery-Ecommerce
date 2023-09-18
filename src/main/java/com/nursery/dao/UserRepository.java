package com.nursery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nursery.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
