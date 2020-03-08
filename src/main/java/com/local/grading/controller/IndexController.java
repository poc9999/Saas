package com.local.grading.controller;

import com.local.grading.exception.BizException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    private String index(){

        throw new BizException(12,"23232");
//        return "index";
    }
}
