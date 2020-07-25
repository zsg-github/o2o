package com.njupt.o2o.dao;

import com.njupt.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCategoryDao {
    List<ShopCategory> queryShopCategory(@Param("shopCategory") ShopCategory shopCategory);

}
