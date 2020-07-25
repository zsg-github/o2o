package com.njupt.o2o.dao;

import com.njupt.o2o.BastTest;
import com.njupt.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaDaoTest extends BastTest {
    @Autowired
    private  AreaDao areaDao;
    @Test
    public void testQueryArea(){
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }


}
