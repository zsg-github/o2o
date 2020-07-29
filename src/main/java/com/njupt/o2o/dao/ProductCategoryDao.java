package com.njupt.o2o.dao;

import com.njupt.o2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通過shopId查詢店鋪商品類別
     */
    List<ProductCategory> queryProductCategoryList(@Param("shopId") long shopId);

    /**
     * 批量新增商品类别
     * @param productCategoryList
     * @return
     */
    int batchInsertProductCategory(List<ProductCategory> productCategoryList);

    /**
     * 删除指定商品类别
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId,@Param("shopId") long shopId);
}
