package com.local.grading.controller;

import com.local.grading.service.RegionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author caishen
 * @version 1.0
 * @className IndexController
 * @date 2020/2/24 14:45
 * 自分で書いたコードの各行を担当する
 **/
@Controller
public class IndexController {

    @Resource
    RegionService regionService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


}
