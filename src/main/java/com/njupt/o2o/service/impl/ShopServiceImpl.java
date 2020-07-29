package com.njupt.o2o.service.impl;

import com.njupt.o2o.dao.ImageHolder;
import com.njupt.o2o.dao.ShopDao;
import com.njupt.o2o.dto.ShopExecution;
import com.njupt.o2o.entity.Shop;
import com.njupt.o2o.enums.ShopStateEnum;
import com.njupt.o2o.exceptions.ShopOperationException;
import com.njupt.o2o.service.ShopService;
import com.njupt.o2o.util.CalculateUtil;
import com.njupt.o2o.util.ImageUtil;
import com.njupt.o2o.util.PathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transient
    public ShopExecution addShop(Shop shop, ImageHolder imageHolder) {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                throw new ShopOperationException("店铺创建失败");
            } else {
                if (imageHolder.getImage() != null) {
                    //存储图片
                    try {
                        //给shop.shopImg赋值,因为插入shop语句声明 useGeneratedKeys="true"，所以可得shopId
                        addShopImg(shop, imageHolder);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImg error" + e.getMessage());
                    }
                    //拿到新增店铺主键后继续添加图片，才用更新的方式
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <= 0) {
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("addShop error" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop, ImageHolder imageHolder) {
        //获取shop图片目录的相对值路径:合成相对路径:/upload/item/shop/" + shopId + "/
        String targetAddr = PathUtils.getShopImagePath(shop.getShopId());
        //传入图片目录相对路径targetAddr将图片处理后保存到本机位置，并返回图片相对路径/upload/item/shop/" + shopId +/xxxxxx/+ "/picture.jpg
        String shopImgAddr = ImageUtil.generateThumbnail(imageHolder, targetAddr);
        shop.setShopImg(shopImgAddr);
    }


    @Override
    public ShopExecution modifyShop(Shop shop, ImageHolder imageHolder) {
        if(shop == null ||shop.getShopId() == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }else {
            //1.判断是否需要处理图片
            try{
                if (imageHolder.getImage() != null && imageHolder.getImageName() != null && !"".equals(imageHolder.getImageName())){
                    Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                    if(tempShop.getShopImg() != null){
                        ImageUtil.deleteImg(tempShop.getShopImg());
                    }
                    addShop(shop,imageHolder);
                }
                //更新店铺信息
                shop.setLastEditTime(new Date());
                int effectNum = shopDao.updateShop(shop);
                if (effectNum <= 0){
                    return new ShopExecution(ShopStateEnum.INNER_ERROR);
                }else {
                    shop = shopDao.queryByShopId(shop.getShopId());
                    return new ShopExecution(ShopStateEnum.SUCCESS,shop);
                }
            }catch (Exception e){
                throw new ShopOperationException("modifyShop error" + e.getMessage());
            }
        }
    }

    @Override
    public Shop getByShopId(Long shopId) {
        return shopDao.queryByShopId(shopId);
    }

    @Override
    public ShopExecution getShopList(Shop shop, int pageIndex, int pageSize) {
        int rowIndex = CalculateUtil.calculateRowIndex(pageIndex,pageSize);
        List<Shop> shopList = shopDao.queryShopList(shop,rowIndex,pageSize);
        int count = shopDao.queryShopCount(shop);
        ShopExecution se = new ShopExecution();
        if(shopList != null){
            se.setShopList(shopList);
            se.setCount(count);
        }else {
            se.setState(ShopStateEnum.INNER_ERROR.getState());
        }
        return se;
    }
}
