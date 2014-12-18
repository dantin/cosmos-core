package com.cosmos.core.exception;

/**
 * 错误代码
 *
 * @author David
 */
public enum ErrorCode {

    @Error(code = "0000", message = "成功！")
    success_0,
    @Error(code = "1000", message = "系统错误！")
    system_1000,
    @Error(code = "1021", message = "参数有误！")
    param_1021;

    /**
     * 返回错误码
     */
    public Error getError() {
        try {
            return this.getClass().getField(this.name()).getAnnotation(Error.class);
        } catch (Exception e) {
            return null;
        }
    }
}
