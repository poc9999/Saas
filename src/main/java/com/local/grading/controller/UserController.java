package com.local.grading.controller;

import com.local.grading.context.BaseContextHandler;
import com.local.grading.domain.User;
import com.local.grading.mapper.UserMapper;
import com.local.grading.result.R;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/user")
@ApiModel(description = "用户信息")
public class UserController {

    @Resource
    private UserMapper userMapper;

    /**
     * 获取数据
     * @param request
     * @return
     */
    @GetMapping("/get")
    @ResponseBody
    private R getUser(HttpServletRequest request) {
        String tenantId = BaseContextHandler.getTenantId();
        log.info("当前租户:{}", tenantId);
        List<User> users = userMapper.selectList(null);
        return R.success(users).setPath(request.getRequestURI());
    }
    /**
     * 插入数据
     * @param request
     * @return
     */
    @PutMapping("/insert")
    @ResponseBody
    private R insertUser(HttpServletRequest request) {
        String tenantId = BaseContextHandler.getTenantId();
        log.info("当前租户:{}", tenantId);
        User user = new User().setName("zhangsan");
        int insert = userMapper.insert(user);
        return R.success(insert).setPath(request.getRequestURI());
    }

    /**
     * 获取用户和地址
     * @param request
     * @return
     */
    @GetMapping("/getUserAndAddr")
    @ResponseBody
    private R getUserAndAddr(HttpServletRequest request) {
        String tenantId = BaseContextHandler.getTenantId();
        log.info("当前租户:{}", tenantId);

        List<User> userAndAddr = userMapper.getUserAndAddr(null);
        return R.success(userAndAddr).setPath(request.getRequestURI());
    }
}
