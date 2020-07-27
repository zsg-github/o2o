package com.njupt.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/shopadmin", method = RequestMethod.GET)
/**
 * 主要用于解析路由并转发到相应的html中
 *
 *   路由过程：由网页url请求映射到这里，然后这里转发到相应的html页面，
 *   由这个html对应的js文件路由到对应的controller获取信息填充这个网页。
 */
public class ShopAdminController {

    @RequestMapping(value = "/shopoperation")
    public String shopOperation() {
        //前缀和后缀已在视图解析器中做了处理
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist")
    public String shopList() {
        //前缀和后缀已在视图解析器中做了处理
        return "shop/shoplist";
    }
    @RequestMapping(value = "/shopmanagement")
    public String shopManagement() {
        // 转发至店铺管理页面
        return "shop/shopmanagement";
    }

    @RequestMapping(value = "/productcategorymanagement", method = RequestMethod.GET)
    private String productCategoryManage() {
        // 转发至商品类别管理页面
        return "shop/productcategorymanagement";
    }

    @RequestMapping(value = "/productoperation")
    public String productOperation() {
        // 转发至商品添加/编辑页面
        return "shop/productoperation";
    }

    @RequestMapping(value = "/productmanagement")
    public String productManagement() {
        // 转发至商品管理页面
        return "shop/productmanagement";
    }


}
