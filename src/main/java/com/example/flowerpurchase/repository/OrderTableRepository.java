package com.example.flowerpurchase.repository;

import com.example.flowerpurchase.model.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderTableRepository extends JpaRepository<OrderTable, Long> {
    List<OrderTable> findAllByUid(long uid);
}
