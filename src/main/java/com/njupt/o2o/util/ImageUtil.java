package com.njupt.o2o.util;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sun.rmi.runtime.Log;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {

    //获取classPath：根路径
    private static String basePath =  Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 将CommonsMultipartFile转成File
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile){
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 传入原图片地址（绝对路径），加工后把新图片存储到本机，并返回相对路径
     * 处理缩略图，并生成新图片的相对路径
     */
    public static String generateThumbnail(InputStream shopImgInputStream, String fileName, String targetAddr){
        String realFileName = getRandomFileName();
        String extensionName = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName +extensionName;
        logger.debug("current relativePath: " + relativeAddr);
        //生成存放图片文件全路径
        File dest = new File(PathUtils.getImgBasePath() + relativeAddr);
        logger.debug("current completePath: " + PathUtils.getImgBasePath() + relativeAddr);
        //将图片转换成Thumbnail对象处理文件后存到本机位置dest
        try{
            //没改正过来imgFile.getName()是错误的，导致只有文件名，最后被拼成：“D:/IDEA_workplace/o2o/abv.jpg，报错找不到文件
            Thumbnails.of(shopImgInputStream).size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath+"/watermark.jpg")),0.2f)
                    .outputQuality(0.8f)
                    .toFile(dest);
        }catch (IOException e){
            e.printStackTrace();
            logger.error(e.toString());
        }
        //返回相对路径存到数据库，存相对路径便于系统转移
        return relativeAddr;

    }

    /**
     * 创建目标文件路径所涉及的目录
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtils.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取文件流的扩展名
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.indexOf("."));

    }

    /**
     * 生成随机文件名，当前年月日时分秒
     * @return
     */
    private static String getRandomFileName() {
        //获取随机五位数
        int randomNum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return randomNum + nowTimeStr;

    }

    public static void main(String[] args) throws IOException {
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Thumbnails.of(new File("D:/o20ProjectDev/abv.jpg")).size(200,200)
                .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath+"/watermark.jpg")),0.25f)
                .outputQuality(0.8f).toFile("D:/o20ProjectDev/abvnew.jpg");
    }


    public static void deleteFile(File filePath) {
        if(filePath != null && filePath.exists()){
            if(filePath.isFile()){
                filePath.delete();
            }else {
                for(File f : filePath.listFiles()){
                    deleteFile(f);
                }
            }
            //最后删除目录
            filePath.delete();
        }

    }

    public static void deleteImg(String shopImg) {
        File imgPath = new File(PathUtils.getImgBasePath()+shopImg);
        deleteFile(imgPath);
    }
}
