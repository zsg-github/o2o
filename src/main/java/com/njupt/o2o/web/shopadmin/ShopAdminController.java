package com.njupt.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/shopadmin",method = RequestMethod.GET)
public class ShopAdminController  {

    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        //前缀和后缀已在视图解析器中做了处理
        return "shop/shopoperation";
    }

}
