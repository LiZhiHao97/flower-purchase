package com.example.flowerpurchase.repository;

import com.example.flowerpurchase.model.Address;
import com.example.flowerpurchase.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
