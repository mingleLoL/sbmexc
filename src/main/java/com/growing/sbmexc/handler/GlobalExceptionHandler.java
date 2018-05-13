package com.growing.sbmexc.handler;

import com.growing.sbmexc.entity.Result;
import com.growing.sbmexc.enums.ResultEnum;
import com.growing.sbmexc.exception.MyException;
import com.growing.sbmexc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/3/28
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Result exceptionHandler(HttpServletRequest req, Exception e){
        logger.info("Request URL: {}", req.getRequestURL());
        logger.error("Traces : {}", e.toString());
        if(e instanceof MyException){
            return ResultUtil.error(((MyException) e).getCode(), e.getMessage());
        }else {
            MyException exception = new MyException(ResultEnum.UNKNOWN_ERROR);
            return ResultUtil.error(exception.getCode(), exception.getMessage());
        }
    }
}
