package com.growing.sbmexc.service;

import com.growing.sbmexc.entity.Area;
import org.springframework.validation.BindingResult;

import java.util.List;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/3/26
 */
public interface AreaService {

    List<Area> getAreaList();

    Area getAreaById(int areaId);

    boolean addArea(Area area, BindingResult result);

    boolean modifyArea(Area area);

    boolean deleteArea(int areaId);
}
