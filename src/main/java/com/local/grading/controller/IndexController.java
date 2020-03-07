package com.local.grading.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author caishen
 * @version 1.0
 * @className IndexController
 * @date 2020/3/7 22:25
 * 自分で書いたコードの各行を担当する
 **/
@Controller
public class IndexController {

    @RequestMapping("/index")
    private String index(){
        return "index";
    }
}
