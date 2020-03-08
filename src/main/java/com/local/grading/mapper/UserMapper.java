package com.local.grading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.local.grading.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author caishen
 * @version 1.0
 * @className UserMapper
 * @date 2020/3/7 23:10
 * 自分で書いたコードの各行を担当する
 **/
public interface UserMapper extends BaseMapper<User> {
    /**
     * 自定义SQL：默认也会增加多租户条件
     * 参考打印的SQL
     * @return
     */
    Integer myCount();

    List<User> getUserAndAddr(@Param("username") String username);

    List<User> getAddrAndUser(@Param("name") String name);
}
