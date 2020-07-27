package com.njupt.o2o.service;

import com.njupt.o2o.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getProductCatagoryList(long shopId);

}
