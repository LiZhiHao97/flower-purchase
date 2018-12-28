package com.example.flowerpurchase.repository;

import com.example.flowerpurchase.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressRepositoryTest {

    @Resource
    private  AddressRepository addressRepository;

    @Test
    public void testSave() {
        addressRepository.save(new Address(1, "狗篮子", "13868224404", "浙江省", "舟山市", "普陀区", "沈家门", "asdasd"));
    }

    @Test
    public void testDelete() {
        addressRepository.deleteById(1l);
    }
}
