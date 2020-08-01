package com.jack.rookiepractice.controller;

import com.jack.common.annotation.BaseResponse;
import com.jack.common.enm.ResponseCode;
import com.jack.common.exception.BaseException;
import com.jack.rookiepractice.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jack
 * @Classname UserController
 * Create by jack 2019/12/22
 * @date: 2019/12/22 21:13
 * @Description:
 */
@BaseResponse
@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Integer userId){
        if(userId.equals(0)){
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
        if(userId.equals(1)){
            throw new RuntimeException();
        }
        UserDTO user=new UserDTO();
        user.setId(userId);
        user.setName("test");
        return user;
    }
}
