package com.njupt.o2o.dao;

import com.njupt.o2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通過shopId查詢店鋪商品類別
     */
    List<ProductCategory> queryProductCategoryList(@Param("shopId") long shopId);
}
