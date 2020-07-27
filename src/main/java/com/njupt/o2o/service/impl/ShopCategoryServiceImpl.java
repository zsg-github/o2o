package com.njupt.o2o.service.impl;

import com.njupt.o2o.dao.ShopCategoryDao;
import com.njupt.o2o.entity.Shop;
import com.njupt.o2o.entity.ShopCategory;
import com.njupt.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategory) {
        List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(shopCategory);
        return shopCategoryList;
    }
}
