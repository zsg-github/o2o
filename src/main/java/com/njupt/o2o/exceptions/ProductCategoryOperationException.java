package com.njupt.o2o.exceptions;

import com.njupt.o2o.entity.ProductCategory;

public class ProductCategoryOperationException extends RuntimeException{

    private static final long serialVersionUID = 6220701709426660867L;

    public ProductCategoryOperationException(String msg){super(msg);}
}
