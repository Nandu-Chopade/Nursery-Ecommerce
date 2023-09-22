package com.nursery.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
