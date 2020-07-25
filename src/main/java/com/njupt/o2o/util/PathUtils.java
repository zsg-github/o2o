package com.njupt.o2o.util;

public class PathUtils {
    private static  String separator = System.getProperty("file.separator");

    /**
     * 新图片存储目录根路径
     * @return
     */
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "D:/o20ProjectDev/image/";
        }else {
            basePath = "/home/zhang/image/";
        }
        basePath = basePath.replace("/",separator);
        return basePath;
    }

    /**
     * 图片相对路径
     * @param shopId
     * @return
     */
    public static String getShopImagePath(long shopId){
        String imagePath = "upload/item/shop/" + shopId + "/";
        return imagePath.replace("/",separator);

    }
}
