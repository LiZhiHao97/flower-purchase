package com.example.flowerpurchase.repository;

import com.example.flowerpurchase.model.Product;
import com.example.flowerpurchase.model.ShoppingCart;
import com.example.flowerpurchase.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartRepositoryTest {

    @Resource
    private ShoppingCartRepository shoppingCartRepository;

    @Test
    public void testSave() {
        shoppingCartRepository.save(new ShoppingCart(1, 2, "水仙花", 10, 10, 0, "222"));
    }

    @Test
    public void testDelete() {
        shoppingCartRepository.deleteById(1l);
    }

    @Test
    public void testFindALlByUid() {
        List<ShoppingCart> list = shoppingCartRepository.findAllByUid(1l);
        for (ShoppingCart item: list) {
            System.out.println(item.getCreate_time());
        }
    }

    @Test
    public void testUpdate() {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(2l).get();
        shoppingCart.setQuantity(shoppingCart.getQuantity() + 1);
        shoppingCartRepository.save(shoppingCart);
    }

    @Test
    public void testFindByUidAndPid() {
        ShoppingCart shoppingCart = shoppingCartRepository.findAllByUidAndPid(2l, 8l);
        System.out.println(shoppingCart);
    }
}
