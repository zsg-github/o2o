package com.njupt.o2o.dao;

import com.njupt.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

public interface ShopDao {
    /**
     * 通过shopId查询店铺
     */
    Shop queryByShopId(@Param("shopId")long shopId);
    /**
     * 新增店铺
     */
    int insertShop(@Param("shop") Shop shop);

    /**
     * 更新店铺
     */
    int  updateShop(@Param("shop") Shop shop);

}
