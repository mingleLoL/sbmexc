package com.growing.sbmexc.utils;

import com.growing.sbmexc.entity.Result;
import com.growing.sbmexc.enums.ResultEnum;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/5/12
 */
public class ResultUtil {

    public static <T> Result success(T data){
        Result result = new Result();
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setData(data);
        return result;
    }

    public static Result success(){
        Result result = success(null);
        return result;
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
