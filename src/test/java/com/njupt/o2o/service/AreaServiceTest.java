package com.njupt.o2o.service;

import com.njupt.o2o.BastTest;
import com.njupt.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BastTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        assertEquals("荷苑",areaList.get(0).getAreaName());
    }


}
