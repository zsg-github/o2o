package com.njupt.o2o.service;

import com.njupt.o2o.dao.ImageHolder;
import com.njupt.o2o.dto.ShopExecution;
import com.njupt.o2o.entity.Shop;

import java.io.File;
import java.io.InputStream;

public interface ShopService {


    ShopExecution getShopList(Shop shop,int pageIndex, int pageSize);

    ShopExecution addShop(Shop shop, ImageHolder imageHolder);

    Shop getByShopId(Long shopId);

    ShopExecution modifyShop(Shop shop, ImageHolder imageHolder);
}
