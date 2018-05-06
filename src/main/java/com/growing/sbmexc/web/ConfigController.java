package com.growing.sbmexc.web;

import com.growing.sbmexc.entity.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/5/6
 */

@RestController
public class ConfigController {

    @Autowired
    private Config myEnv;

    @RequestMapping(value = "config", method = RequestMethod.GET)
    public String config(){
        return "Name: "+myEnv.getName()+"; Port: "+myEnv.getPort();
    }
}
