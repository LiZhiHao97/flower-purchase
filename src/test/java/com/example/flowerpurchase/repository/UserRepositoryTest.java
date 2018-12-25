package com.example.flowerpurchase.repository;

import com.example.flowerpurchase.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void testSave() {

        userRepository.save(new User("lizhihao2", "123456","男", "940166841@qq.com",  0));

//		Assert.assertEquals(3, userRepository.findAll().size());
//		Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("bb", "bb@126.com").getNickName());
//		userRepository.delete(userRepository.findByUserName("aa"));
    }

    @Test
    public void testFindById() {
        User user = userRepository.findById(1l).get();
        System.out.println(user.getPassword());
    }

    @Test
    public void testFindByUserName() {
        User user = userRepository.findByUsername("lizhihao");
        System.out.println(user.getPassword());
    }
}
