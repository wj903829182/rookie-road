package com.jack.common.exception;

import com.jack.common.enm.ResponseCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jack
 * @Classname BaseException
 * Create by jack 2019/12/22
 * @date: 2019/12/22 20:47
 * @Description:
 * 业务异常类，继承运行时异常，确保事务正常回滚
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {
    private ResponseCode code;

    public BaseException(ResponseCode code) {
        this.code = code;
    }

    public BaseException(Throwable cause, ResponseCode code) {
        super(cause);
        this.code = code;
    }
}
