package com.lq.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tianmeng
 * @date 2020/11/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Integer id;

    private Long productId;

    private Long total;

    private Integer used;

    private Integer residue;
}
