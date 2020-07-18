package com.liuhangs.springcloud.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 11757
 * @DATE 2020/7/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
