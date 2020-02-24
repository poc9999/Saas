package com.local.grading.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegionMapperTest {

    @Resource
    RegionMapper regionMapper;

    @Test
    public void test(){
        System.out.println(regionMapper.selectList(null));
    }

}