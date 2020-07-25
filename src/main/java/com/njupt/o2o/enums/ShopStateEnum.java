package com.njupt.o2o.enums;

public enum ShopStateEnum {
    CHECK(0,"审核中"), OFFLINE(-1,"非法店铺"), SUCCESS(1,"操作成功"),
    PASS(2,"通过认证"), INNER_ERROR(-1001,"系统内部错误"),NULL_SHOP(-1003,"店铺信息为空");
    private int state;
    private String statusInfo;

    ShopStateEnum(int state, String statusInfo) {
        this.state = state;
        this.statusInfo = statusInfo;
    }
    /**
     * 依据传入的state返回相应的enum值
     *
     */
    public static ShopStateEnum stateOf(int state){
        for(ShopStateEnum shopStateEnum : values()){
            if(shopStateEnum.getState() == state){
                return shopStateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStatusInfo() {
        return statusInfo;
    }
}
