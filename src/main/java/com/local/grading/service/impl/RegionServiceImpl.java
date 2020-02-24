package com.local.grading.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.local.grading.domain.Region;
import com.local.grading.mapper.RegionMapper;
import com.local.grading.service.RegionService;
import org.springframework.stereotype.Service;

/**
 * @author caishen
 * @version 1.0
 * @className RegionServiceImpl
 * @date 2020/2/24 14:33
 * 自分で書いたコードの各行を担当する
 **/
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements RegionService {
}
