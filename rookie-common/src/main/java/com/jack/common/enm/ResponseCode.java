package com.jack.common.enm;

/**
 * Created By Jack on 2019/12/22
 *
 * @author Jack
 * @date 2019/12/22 11:04
 * @Description:
 * 统一返回状态码
 * 枚举返回状态码
 * 参考资料：https://segmentfault.com/a/1190000019795918
 */

public enum ResponseCode {
    /**
     * 成功
     */
    SUCCESS(1,"success"),
    /**
     * 资源不存在的状态码
     */
    RESOURCES_NOT_EXIST(404, "资源不存在"),
    /**
     * 内部错误
     */
    SERVICE_ERROR(500,"内部服务错误");
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 返回错误信息
     */
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
