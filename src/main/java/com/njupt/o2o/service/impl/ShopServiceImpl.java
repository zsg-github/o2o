package com.njupt.o2o.service.impl;

import com.njupt.o2o.dao.ShopDao;
import com.njupt.o2o.dto.ShopExecution;
import com.njupt.o2o.entity.Shop;
import com.njupt.o2o.enums.ShopStateEnum;
import com.njupt.o2o.exceptions.ShopOperationException;
import com.njupt.o2o.service.ShopService;
import com.njupt.o2o.util.ImageUtil;
import com.njupt.o2o.util.PathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;
    @Override
    @Transient
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        if(shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            int effectedNum = shopDao.insertShop(shop);
            if(effectedNum <= 0){
                throw new ShopOperationException("店铺创建失败");
            }else {
                if(shopImgInputStream != null){
                    //存储图片
                    try {
                    addShopImg(shop, shopImgInputStream,fileName);
                    }catch (Exception e){
                        throw new ShopOperationException("addShopImg error" + e.getMessage());
                    }
                    //更新店铺图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if(effectedNum <= 0){
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }
        }catch (Exception e){
            throw new ShopOperationException("addShop error" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream,String fileName) {
        //获取shop图片目录的相对值路径:合成相对路径:/upload/item/shop/" + shopId + "/
        String targetAddr = PathUtils.getShopImagePath(shop.getShopId());
        //传入图片目录相对路径targetAddr将图片处理后保存到本机位置，并返回图片相对路径/upload/item/shop/" + shopId +/xxxxxx/+ "/picture.jpg
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream,fileName,targetAddr);
        shop.setShopImg(shopImgAddr);
    }


    @Override
    public ShopExecution modifyShop(Shop shop, Object o, Object o1) {
        return null;
    }

    @Override
    public Shop getByShopId(Long shopId) {
        return shopDao.queryByShopId(shopId);
    }
}
