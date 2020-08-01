package com.jack.rookiepractice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author jack
 * @Classname UserDTO
 * Create by jack 2019/12/22
 * @date: 2019/12/22 21:12
 * @Description:
 */
@Data
@EqualsAndHashCode
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 2590011337897823240L;
    private Integer id;

    private String name;
}
