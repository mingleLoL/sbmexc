package com.growing.sbmexc.dao;

import com.growing.sbmexc.entity.Area;

import java.util.List;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/3/25
 */
public interface AreaDao {

    List<Area> queryArea();

    Area queryAreaById(int areaId);

    int updateArea(Area area);

    int insertArea(Area area);

    int deleteArea(int areaId);
}
