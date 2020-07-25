package com.njupt.o2o.service;

import com.njupt.o2o.entity.Shop;
import com.njupt.o2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategory);
}
