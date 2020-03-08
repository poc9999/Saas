package com.local.grading.mapper;


import com.local.grading.GradingApplication;
import com.local.grading.context.BaseContextHandler;
import com.local.grading.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = GradingApplication.class)
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Before
    public void before(){
        BaseContextHandler.setTenant("0");
    }

    @Test
    public void test(){
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void aInsert() {
        User user = new User();
        user.setName("一一");
        Assert.assertTrue(userMapper.insert(user) > 0);
        user = userMapper.selectById(user.getId());
        Assert.assertTrue(1 == user.getTenantId());
    }

}