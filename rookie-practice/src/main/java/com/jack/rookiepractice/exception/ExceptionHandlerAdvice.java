package com.jack.rookiepractice.exception;

import com.jack.common.enm.ResponseCode;
import com.jack.common.exception.BaseException;
import com.jack.common.exception.BusinessException;
import com.jack.common.rest.Result;
import com.jack.common.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jack
 * @Classname ExceptionHandlerAdvice
 * Create by jack 2019/12/22
 * @date: 2019/12/22 20:51
 * @Description:
 * 异常处理器
 * @ControllerAdvice(annotations = BaseResponse.class)
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {
    /**
     * 处理未捕获的Exception
     * @param e 异常
     * @return 统一响应体
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        log.error(e.getMessage(),e);
        return ResultUtils.fail(ResponseCode.SERVICE_ERROR.getCode(), ResponseCode.SERVICE_ERROR.getMsg());
    }

    /**
     * 处理未捕获的RuntimeException
     * @param e 运行时异常
     * @return 统一响应体
     */
    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntimeException(RuntimeException e){
        log.error(e.getMessage(),e);
        return ResultUtils.fail(ResponseCode.SERVICE_ERROR.getCode(),ResponseCode.SERVICE_ERROR.getMsg());
    }

    /**
     * 基础异常异常BaseException
     * @param e 业务异常
     * @return 统一响应体
     */
    @ExceptionHandler(BaseException.class)
    public Result handleBaseException(BaseException e){
        log.error(e.getMessage(),e);
        ResponseCode code=e.getCode();
        return ResultUtils.fail(code.getCode(),code.getMsg());
    }

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BaseException e){
        log.error(e.getMessage(),e);
        ResponseCode code=e.getCode();
        return ResultUtils.fail(code.getCode(),code.getMsg());
    }
}
