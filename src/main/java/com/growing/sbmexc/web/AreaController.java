package com.growing.sbmexc.web;

import com.growing.sbmexc.entity.Area;
import com.growing.sbmexc.entity.Result;
import com.growing.sbmexc.enums.ResultEnum;
import com.growing.sbmexc.service.AreaService;
import com.growing.sbmexc.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/3/28
 */
@RestController
@RequestMapping(value = "/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    public Result listArea(){
        List<Area> list = areaService.getAreaList();
        return ResultUtil.success(list);
    }

    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    public Result getAreaById(Integer areaId){
        Area area = areaService.getAreaById(areaId);
        return ResultUtil.success(area);
    }

    @RequestMapping(value = "/getarea{areaId}", method = RequestMethod.GET)
    public Result getArea(@PathVariable Integer areaId){
        Area area = areaService.getAreaById(areaId);
        return ResultUtil.success(area);
    }


    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    public Result addArea(@RequestBody @Valid Area area, BindingResult result){
        if(result.hasErrors()){
            return ResultUtil.error(ResultEnum.INVALID_PRIORITY.getCode(), ResultEnum.INVALID_PRIORITY.getMsg());
        }
        areaService.addArea(area, result);
        return ResultUtil.success(area);
    }

    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    public Result modifyArea(@RequestBody Area area){
        areaService.modifyArea(area);
        return ResultUtil.success(area);
    }

    @RequestMapping(value = "/deletearea", method = RequestMethod.GET)
    public Result deleteArea(Integer areaId){
        areaService.deleteArea(areaId);
        return ResultUtil.success();
    }
}
