package com.njupt.o2o.dao;

import com.njupt.o2o.entity.Product;
import org.apache.ibatis.annotations.Param;

public interface ProductDao {
    /**
     * 插入商品
     * @param product
     * @return
     */
    int insertProduct(@Param("product") Product product);
}
