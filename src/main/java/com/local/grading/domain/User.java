package com.local.grading.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author caishen
 * @version 1.0
 * @className User
 * @date 2020/3/7 23:10
 * 自分で書いたコードの各行を担当する
 **/
@Data
@Accessors(chain = true)
public class User {
    private Long id;
    /**
     * 租户 ID
     */
    private Long tenantId;
    private String name;

    @TableField(exist = false)
    private String addrName;

}
