package com.nursery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nursery.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // You can define custom query methods here if needed
}

