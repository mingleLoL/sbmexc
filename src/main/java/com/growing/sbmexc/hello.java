package com.growing.sbmexc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/2/19
 */

@RestController
public class hello {
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello SpringBoot!";
    }
}
