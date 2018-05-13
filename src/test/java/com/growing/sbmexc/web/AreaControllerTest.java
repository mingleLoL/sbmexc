package com.growing.sbmexc.web;

import org.hamcrest.core.StringContains;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/5/13
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AreaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @Transactional()
    public void addArea() throws Exception{
        Map map = new HashMap(){
            {
                put("areaName","娜娜大区");
                put("priority","2");
            }
        };
        String str = new JSONObject(map).toString();
        byte[] bytes = str.getBytes();
        mvc.perform(MockMvcRequestBuilders.post("/superadmin/addarea").contentType(MediaType.APPLICATION_JSON)
                .content(bytes)).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0))
                .andExpect(MockMvcResultMatchers.content().string(new StringContains("\"code\":0")));
    }

    @Test
    public void listArea() throws Exception{
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/superadmin/listarea"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        HttpServletRequest request = result.getRequest();

    }
}