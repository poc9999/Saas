package com.local.grading.controller;

import com.local.grading.context.BaseContextHandler;
import com.local.grading.domain.User;
import com.local.grading.mapper.UserMapper;
import com.local.grading.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author caishen
 * @version 1.0
 * @className IndexController
 * @date 2020/3/7 22:25
 * 自分で書いたコードの各行を担当する
 **/
@Controller
@Slf4j
public class IndexController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/index")
    @ResponseBody
    private R index(HttpServletRequest request) {

        String tenantId = BaseContextHandler.getTenantId();
        log.info("当前租户:{}", tenantId);

        List<User> users = userMapper.selectList(null);

        return R.success(users).setPath(request.getRequestURI());

    }
}
