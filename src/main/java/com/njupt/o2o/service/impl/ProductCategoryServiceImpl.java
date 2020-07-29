package com.njupt.o2o.service.impl;

import com.njupt.o2o.dao.ProductCategoryDao;
import com.njupt.o2o.dto.ProductCategoryExecution;
import com.njupt.o2o.entity.ProductCategory;
import com.njupt.o2o.enums.ProductCategoryStateEnum;
import com.njupt.o2o.exceptions.ProductCategoryOperationException;
import com.njupt.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);

    }

    @Override
    public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) {
        if (productCategoryList != null && productCategoryList.size() != 0) {
            int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("店铺类别添加失败");
            } else {
                return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
            }
        } else {
            return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }

    @Override
    public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId) {
        //TODO将此商品类别下的商品的类别Id置为空
       int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId,shopId);
       if (effectedNum <= 0){
           throw new ProductCategoryOperationException("商品类别删除失败");
       }else {
           return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
       }
    }
}
