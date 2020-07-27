package com.njupt.o2o.service;

import com.njupt.o2o.dto.ShopExecution;
import com.njupt.o2o.entity.Shop;

import java.io.File;
import java.io.InputStream;

public interface ShopService {


    ShopExecution getShopList(Shop shop,int pageIndex, int pageSize);

    ShopExecution addShop(Shop shop, InputStream shopImg, String fileName);

    Shop getByShopId(Long shopId);

    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
