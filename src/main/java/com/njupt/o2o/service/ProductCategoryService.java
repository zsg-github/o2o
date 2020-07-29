package com.njupt.o2o.service;

import com.njupt.o2o.dto.ProductCategoryExecution;
import com.njupt.o2o.entity.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryService {

    /**
     * 指定查询某个店铺下的所有类别信息
     *
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategoryList(long shopId);

    /**
     * 批量增加商品类别信息
     *
     * @param productCategoryList
     * @return
     */
    ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList);

    /**
     * 将此类别下的商品的商品类别id置为空，再删除该商品类别
     *
     * @param productCategoryId
     * @param shopId
     * @return
     */
    ProductCategoryExecution deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);

}
