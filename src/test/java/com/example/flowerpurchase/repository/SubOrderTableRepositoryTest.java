package com.example.flowerpurchase.repository;

import com.example.flowerpurchase.model.SubOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubOrderTableRepositoryTest {
    @Resource
    private SubOrderRepository subOrderRepository;

    @Test
    public void testSave() {
        SubOrder subOrder = new SubOrder(1, 9, "水仙花", 299, 5);
        subOrderRepository.save(subOrder);
    }

    @Test
    public void testFindAllByOid() {
        List<SubOrder> list = subOrderRepository.findAllByOid(1l);
        for(SubOrder item: list) {
            System.out.println(item.getPname());
        }
    }
}
