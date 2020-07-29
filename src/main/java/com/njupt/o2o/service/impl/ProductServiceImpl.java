package com.njupt.o2o.service.impl;

import com.njupt.o2o.dao.ImageHolder;
import com.njupt.o2o.dao.ProductDao;
import com.njupt.o2o.dao.ProductImgDao;
import com.njupt.o2o.dto.ProductExecution;
import com.njupt.o2o.entity.Product;
import com.njupt.o2o.entity.ProductImg;
import com.njupt.o2o.enums.ProductStateEnum;
import com.njupt.o2o.exceptions.ProductOperationException;
import com.njupt.o2o.service.ProductService;
import com.njupt.o2o.util.ImageUtil;
import com.njupt.o2o.util.PathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;


    @Override
    @Transactional
    /**
     * 处理缩略图，获取缩略图相对路径并赋值给product
     * 往tb_product写入商品信息，获取productId
     * 结合productId批量处理商品详情图
     * 将商品详情图列表批量插入tb_product_img中
     */
    public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> imageHolderList) throws ProductOperationException {
        if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
            //给商品设置上默认属性
            product.setCreateTime(new Date());
            product.setLastEditTime(new Date());
            //默认是上架的状态
            product.setEnableStatus(1);
            //若商品缩略图不为空则添加
            if (thumbnail != null) {
                addTumbnail(product, thumbnail);
            }
            try {
                //创建商品信息
                int effectedNum = productDao.insertProduct(product);
                if (effectedNum <= 0) {
                    throw new ProductOperationException("创建商品失败");
                }
            } catch (Exception e) {
                throw new ProductOperationException("创建商品失败" + e.toString());
            }
            //若商品详情图不为空则添加
            if (imageHolderList != null && imageHolderList.size() > 0) {
                addProductImgList(product, imageHolderList);
            }
            return new ProductExecution(ProductStateEnum.SUCCESS, product);
        } else {
            // 传参为空则返回空值错误信息
            return new ProductExecution(ProductStateEnum.EMPTY);
        }
    }

    private void addProductImgList(Product product, List<ImageHolder> imageHolderList) {
        // 获取图片存储路径，这里直接存放到相应店铺的文件夹底下
        String dest = PathUtils.getShopImagePath(product.getShop().getShopId());
        List<ProductImg> productImgList = new ArrayList<ProductImg>();
        // 遍历图片一次去处理，并添加进productImg实体类里
        for (ImageHolder productImgHolder : imageHolderList) {
            //String imgAddr = ImageUtil.generateNormalImg(productImgHolder, dest);
            ProductImg productImg = new ProductImg();
          //  productImg.setImgAddr(imgAddr);
            productImg.setProductId(product.getProductId());
            productImg.setCreateTime(new Date());
            productImgList.add(productImg);
        }
        // 如果确实是有图片需要添加的，就执行批量添加操作
        if (productImgList.size() > 0) {
            try {
                int effectedNum = productImgDao.batchInsertProductImg(productImgList);
                if (effectedNum <= 0) {
                    throw new ProductOperationException("创建商品详情图片失败");
                }
            } catch (Exception e) {
                throw new ProductOperationException("创建商品详情图片失败:" + e.toString());
            }
        }
    }

    private void addTumbnail(Product product, ImageHolder thumbnail) {
        String dest = PathUtils.getShopImagePath(product.getShop().getShopId());
        String thumbnailAddr = ImageUtil.generateThumbnail(thumbnail, dest);
        product.setImgAddr(thumbnailAddr);
    }
}
