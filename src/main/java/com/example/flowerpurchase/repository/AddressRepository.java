package com.example.flowerpurchase.repository;

import com.example.flowerpurchase.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByUid(long uid);
}
