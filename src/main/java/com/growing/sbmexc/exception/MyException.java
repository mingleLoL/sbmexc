package com.growing.sbmexc.exception;

import com.growing.sbmexc.enums.ResultEnum;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/5/12
 */
public class MyException extends RuntimeException{

    private Integer code;

    public MyException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
