package com.jack.common.exception;

import com.jack.common.enm.ResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jack
 * @Classname BusinessException
 * Create by jack 2019/12/22
 * @date: 2019/12/22 21:24
 * @Description:
 * 业务异常
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException{
    private ResponseCode code;

    public BusinessException(ResponseCode code) {
        this.code = code;
    }

    public BusinessException(Throwable cause, ResponseCode code) {
        super(cause);
        this.code = code;
    }
}
