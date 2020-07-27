package com.njupt.o2o.dao;

import com.njupt.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    /**
     * 分页查询店铺，可输入条件：店铺名，店铺状态，店铺类别，区域id,owner
     * @param shop
     * @param rowIndex  limit rowIndex, pageSize :从第rowIndex的pageSzie条记录
     * @param pageSize
     * @return
     */
    List<Shop> queryShopList(@Param("shop") Shop shop, @Param("rowIndex") int rowIndex, @Param("pageSize")int pageSize);

    /**
     * 查询符合条件的商铺个数
     * @param shop
     * @return
     */
    int queryShopCount(@Param("shop") Shop shop);



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
