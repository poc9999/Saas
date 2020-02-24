package com.local.grading.domain;

import lombok.Data;

/**
 * @author caishen
 * @version 1.0
 * @className Region
 * @date 2020/2/24 13:54
 * 自分で書いたコードの各行を担当する
 * 区域信息
 **/
@Data
public class Region {

    private String Id;

    private String name;

    private String parentId;

    private String seq;

    private String level;
}
