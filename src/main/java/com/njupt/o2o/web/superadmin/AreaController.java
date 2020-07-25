package com.njupt.o2o.web.superadmin;

import com.njupt.o2o.entity.Area;
import com.njupt.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superAdmin")
public class AreaController {

    //日志对象
    Logger logger = LoggerFactory.getLogger(Area.class);

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listArea(){
        logger.info("程序开始执行");
        Map<String,Object> modelMap = new HashMap<>();
        List<Area> list = new ArrayList<>();
        list = areaService.getAreaList();
        modelMap.put("rows",list);
        modelMap.put("total",list.size());
        logger.error("error测试");
        logger.info("程序结束");
        return modelMap;
    }

}
