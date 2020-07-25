package com.njupt.o2o.service.impl;

import com.njupt.o2o.dao.AreaDao;
import com.njupt.o2o.entity.Area;
import com.njupt.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Service注解在接口上则报错找不到这个bean
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
