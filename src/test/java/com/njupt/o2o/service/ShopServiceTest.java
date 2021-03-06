package com.njupt.o2o.service;

import com.njupt.o2o.BastTest;
import com.njupt.o2o.dto.ShopExecution;
import com.njupt.o2o.entity.Area;
import com.njupt.o2o.entity.PersonInfo;
import com.njupt.o2o.entity.Shop;
import com.njupt.o2o.entity.ShopCategory;
import com.njupt.o2o.enums.ShopStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BastTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void shopServiceTest() throws FileNotFoundException {
        Shop shop =  new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("蜜雪冰城");
        shop.setShopDesc("好喝");
        shop.setShopAddr("test1111111");
        shop.setPhone("2314u98325");
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setPriority("1");
        shop.setEnableStatus(1);
        shop.setAdvice("来啊");
        File shopImg = new File("D:/o20ProjectDev/abv.jpg");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop, is,shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
}
