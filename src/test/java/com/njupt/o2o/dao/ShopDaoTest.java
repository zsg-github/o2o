package com.njupt.o2o.dao;

import com.njupt.o2o.BastTest;
import com.njupt.o2o.entity.Area;
import com.njupt.o2o.entity.PersonInfo;
import com.njupt.o2o.entity.Shop;
import com.njupt.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BastTest {

    @Autowired
    private ShopDao shopDao;
    @Test
    public void testInsertShop(){
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
        shop.setShopName("美学冰红茶让那个");
        shop.setShopDesc("好喝");
        shop.setShopAddr("");
        shop.setPhone("2314u98325");
        shop.setShopImg("1.jpg");
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setPriority("1");
        shop.setEnableStatus(1);
        shop.setAdvice("来啊");
        int effectNum = shopDao.insertShop(shop);
        assertEquals(1,effectNum);


    }

}
