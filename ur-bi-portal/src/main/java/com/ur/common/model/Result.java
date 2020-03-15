package com.ur.common.model;

import com.ur.common.constant.Code;
import com.ur.common.constant.CommonCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用操作结果对象
 */
@Data
@NoArgsConstructor
public class Result<T> implements Serializable {

    /**
     * 返回编码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 正常返回（无业务数据返回）
     * @return
     */
    public static <T> Result<T> succeeded() {
        return new Result(CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMessage(), null);
    }

    /**
     * 正常返回（有业务数据返回）
     * @return
     */
    public static <T> Result<T> succeeded(T data) {
        return new Result(CommonCode.SUCCESS.getCode(), CommonCode.SUCCESS.getMessage(), data);
    }

    /**
     * 正常返回（自定义返回码，并返回业务数据）
     * @param code
     * @param data 无需业务数据返回时请填写null
     * @return
     */
    public static <T> Result<T> succeeded(Code code, T data) {
        return new Result(code.getCode(), code.getMessage(), data);
    }



    /**
     * 正常返回（自定义返回信息，并返回业务数据）
     * @param message
     * @param data 无需业务数据返回时请填写null
     * @return
     */
    public static <T> Result<T> succeeded(String message, T data) {
        return new Result(CommonCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 默认通用的错误返回
     * @return
     */
    public static <T> Result<T> failed() {
        return failed(CommonCode.FAILURE);
    }

    /**
     * 默认通用的错误返回（返回编码使用默认编码，错误信息重写）
     * @return
     */
    public static <T> Result<T> failed(String error) {
        return new Result(CommonCode.FAILURE.getCode(), error, null);
    }

    /**
     * 指定code和异常信息
     *
     * @param code
     * @param error
     * @param <T>
     * @return
     */
    public static <T> Result<T> failed(int code, String error) {
        return new Result(code, error, null);
    }

    /**
     * 错误返回（自定义）
     * @return
     */
    public static <T> Result<T> failed(Code code) {
        return new Result(code.getCode(), code.getMessage(), null);
    }

    /**
     * 错误返回（自定义）
     * @return
     */
    public static <T> Result<T> failed(Code code, String error) {
        return new Result(code.getCode(), error, null);
    }
}

