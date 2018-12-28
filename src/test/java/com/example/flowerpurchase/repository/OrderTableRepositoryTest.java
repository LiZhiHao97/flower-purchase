package com.example.flowerpurchase.repository;

import com.example.flowerpurchase.model.OrderTable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTableRepositoryTest {
    @Resource
    private OrderTableRepository orderTableRepository;

    @Test
    public void testSave() {
        OrderTable orderTable = new OrderTable(1l, "李祉昊", "13868224404", "浙江省舟山市普陀区xxx", "2018-12-28");
        orderTableRepository.save(orderTable);
    }

    @Test
    public void testFindAllByUid() {
        List<OrderTable> list = orderTableRepository.findAllByUid(1l);
        for(OrderTable item: list) {
            System.out.println(item.getUsername());
        }
    }
}
