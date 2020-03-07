package com.local.grading.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RegionMapperTest {

    @Resource
    RegionMapper regionMapper;

    @Resource
    RegionService regionService;

    @Test
    public void save(){
        Region region = new Region();
        String toString = UUID.randomUUID().toString();
        region.setId(toString);

        region.setName("广东省");
        region.setParentId("");
        region.setSeq("0");
        region.setLevel("0");
        log.info("{}",regionService.save(region));

        String toString1 = UUID.randomUUID().toString();
        Region region1 = new Region();
        region1.setId(toString1);
        region1.setName("广州市");
        region1.setParentId(toString);
        region1.setSeq("1");
        region1.setLevel("0.1");
        log.info("{}",regionService.save(region1));


        Region region2 = new Region();
        region2.setId(UUID.randomUUID().toString());
        region2.setName("白云区");
        region2.setParentId(toString1);
        region2.setSeq("0");
        region2.setLevel("0.1.1");
        log.info("{}",regionService.save(region2));
    }

    @Test
    public void del(){
        Region region = new Region();
        log.info("{}",regionService.removeById("da8d389b-e0f7-4954-aba3-aa7f1b72a7c6"));
    }


}