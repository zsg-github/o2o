package com.njupt.o2o.service;

import com.njupt.o2o.dao.ImageHolder;
import com.njupt.o2o.dto.ProductExecution;
import com.njupt.o2o.entity.Product;
import com.njupt.o2o.exceptions.ProductOperationException;

import java.io.InputStream;
import java.util.List;

public interface ProductService {

    /**
     * 添加商品以及图片处理
     * @return
     * @throws ProductOperationException
     */

    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> imageHolderList) throws ProductOperationException;

}
