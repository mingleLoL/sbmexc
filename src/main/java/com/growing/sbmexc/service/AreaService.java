package com.growing.sbmexc.service;

import com.growing.sbmexc.entity.Area;

import java.util.List;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/3/26
 */
public interface AreaService {

    List<Area> getAreaList();

    Area getAreaById(int areaId);

    boolean addArea(Area area);

    boolean modifyArea(Area area);

    boolean deleteArea(int areaId);
}
