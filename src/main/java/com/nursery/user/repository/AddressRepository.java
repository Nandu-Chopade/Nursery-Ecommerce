package com.nursery.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nursery.user.model.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {
    // You can define custom query methods here if needed
}

