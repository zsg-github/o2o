package com.njupt.o2o.service;

import com.njupt.o2o.dto.ShopExecution;
import com.njupt.o2o.entity.Shop;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImg,String fileName);

    Shop getByShopId(Long shopId);

    ShopExecution modifyShop(Shop shop, Object o, Object o1);
}
