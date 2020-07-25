package com.njupt.o2o.dto;

import com.njupt.o2o.entity.Shop;
import com.njupt.o2o.enums.ShopStateEnum;
import java.util.List;

public class ShopExecution {
    //结果状态
    private int state;
    //状态标识
    private String stateInfo;
    //店铺数量
    private int count;
    //操作Shop用到
    private Shop shop;
    //shop列表
    private List<Shop> shopList;

    public ShopExecution() {
    }
    //店铺操作失败的时候使用的构造器
    public ShopExecution(ShopStateEnum shopStateEnum) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStatusInfo() ;
    }

    //店铺操作成功的时候使用的构造器
    public ShopExecution(ShopStateEnum shopStateEnum, Shop shop) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStatusInfo();
        this.shop = shop;
    }
    //店铺操作成功的时候使用的构造器
    public ShopExecution(ShopStateEnum shopStateEnum, List<Shop> shopList) {
        this.state = shopStateEnum.getState();
        this.stateInfo = shopStateEnum.getStatusInfo();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
