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
    DATA_NOT_EXIST(4001, "未查找到数据"),
    /**
     * 内部错误
     */
    SERVICE_ERROR(5000,"内部服务器错误"),
    PARAMETER_ERROR(5001,"参数错误"),
    KNOWN_ERROR(5002,"已知错误"),
    UNKNOWN_ERROR(5003,"未知错误"),
    DATA_ERROR(5004,"未知错误"),

    ;
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
