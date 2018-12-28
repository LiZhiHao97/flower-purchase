package com.example.flowerpurchase.repository;

import com.example.flowerpurchase.model.SubOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubOrderRepository extends JpaRepository<SubOrder, Long> {
    List<SubOrder> findAllByOid(long oid);
}
