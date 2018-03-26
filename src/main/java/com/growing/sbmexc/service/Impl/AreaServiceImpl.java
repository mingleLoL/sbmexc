package com.growing.sbmexc.service.Impl;

import com.growing.sbmexc.dao.AreaDao;
import com.growing.sbmexc.entity.Area;
import com.growing.sbmexc.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: yinm5
 * @Version: 1.0
 * @Date:2018/3/26
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        List<Area> areaList = areaDao.queryArea();
        return areaList;
    }

    @Override
    public Area getAreaById(int areaId) {
        Area area= areaDao.queryAreaById(areaId);
        return area;
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int affectNum = areaDao.insertArea(area);
                if(affectNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId() != null && !"".equals(area.getAreaId())){
            area.setLastEditTime(new Date());
            try {
                int affectNum = areaDao.updateArea(area);
                if(affectNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("更新区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败"+e.toString());
            }
        }else {
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try {
                int affectNum = areaDao.deleteArea(areaId);
                if(affectNum > 0){
                    return true;
                }else{
                    throw new RuntimeException("删除区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败"+e.toString());
            }
        }else {
            throw new RuntimeException("区域id不能为空");
        }
    }
}
