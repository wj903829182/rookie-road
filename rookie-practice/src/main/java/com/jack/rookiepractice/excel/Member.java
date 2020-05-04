package com.jack.rookiepractice.excel;

import lombok.Data;

import java.util.Date;

/**
 * @author jack
 * @Classname Member
 * Create by jack 2020/5/3
 * @date: 2020/5/3 08:42
 * @Description:
 */
@Data
public class Member {
    private Integer code;
    private String name;
    private Integer age;
    private Date birth;

    public Member() {
    }

    public Member(Integer code, String name, Integer age, Date birth) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.birth = birth;
    }
}
