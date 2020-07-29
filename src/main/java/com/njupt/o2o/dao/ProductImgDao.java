package com.njupt.o2o.dao;

import com.njupt.o2o.entity.ProductImg;

import java.util.List;

public interface ProductImgDao {
    /**
     *批量添加商品详情图
     * @param productImgList
     * @return
     */
    int batchInsertProductImg(List<ProductImg> productImgList);
}
