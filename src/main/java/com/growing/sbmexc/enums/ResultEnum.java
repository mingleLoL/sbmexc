package com.growing.sbmexc.enums;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/5/12
 */
public enum ResultEnum {
    SUCCESS(0,"success"),
    UNKNOWN_ERROR(-1, "未知错误"),
    EMPTY_AREAID(1, "区域ID不能为空"),
    EMPTY_AREA(2, "区域信息不能为空"),
    INVALID_PRIORITY(3, "权重值无效");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
