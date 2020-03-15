package com.ur.common.constant;

/**
 * 通用web层接口返回码
 */
public enum CommonCode implements Code {
    /**
     * 正常响应逻辑
     */
    SUCCESS(0, "成功"),
    FAILURE(-1, "处理失败"),
    UNKNOWN(-2, "未知错误"),
    NULL_EXCEPTION(-3, "空指针异常"),
    NOT_LOGIN_IN(-4, "未登录"),
    PARAM_ERROR(-5, "参数错误"),
    EXISTS_DATA(-6, "数据已存在");

    private Integer code;
    private String message;

    CommonCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
