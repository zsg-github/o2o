package com.njupt.o2o.service.impl;

import com.njupt.o2o.dao.ProductCategoryDao;
import com.njupt.o2o.entity.ProductCategory;
import com.njupt.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getProductCatagoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);

    }
}
