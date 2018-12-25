package com.example.flowerpurchase.repository;

import com.example.flowerpurchase.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Resource
    private  ProductRepository productRepository;

    @Test
    public void testSave() {
        productRepository.save(new Product("桃花", "这是菊花", "菊花.jpg", 399, 0, "2018"));
    }

    @Test
    public void testDelete() {
        productRepository.deleteById(1l);
    }

    @Test
    public void testFindByNameLike() {
        String name = "花";
        List<Product> list = productRepository.findByNameLike("%" + name + "%");
        System.out.println(list.size());
        for (Product item: list) {
            System.out.println(item.getName());
        }
    }
}
