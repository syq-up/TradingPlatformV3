package com.shiyq.util;

import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @author shiyq
 * @create 2021-02-26 21:05
 */
public class UploadFile {

    // 绝对路径
    private static String absolutePath = "";
    // 上传文件存放位置
    private static String uploadDir = "static/upload/";

    /**
     * 单文件上传
     * @param file  需要上传的文件
     * @return  文件名
     */
    public static String uploadFile(MultipartFile file) {
        // 如果路径不存在则创建
        createDirIfNotExists();
        // 获取文件后缀名，如果不需要"."，可以在最后+1
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        // 更改文件名
        String headImg = UUID.randomUUID().toString() + suffix;
        // 设置上传文件路径
        String uploadFilePath = absolutePath + "userHeadImg\\" + headImg;
        //通过CommonsMultipartFile的方法直接写文件
        try{
            file.transferTo(new File(uploadFilePath));
        } catch (IOException e){
            e.printStackTrace();
        }
        return uploadFilePath;
    }

    /**
     * 多文件上传
     * @param files 文件集合
     * @return  上传路径
     */
    public static String uploadFiles(MultipartFile[] files) {

        // 如果路径不存在则创建
        createDirIfNotExists();

        // 为文件再创建一级目录防止重名
        String uuidPath = UUID.randomUUID().toString();
        File uploadPath = new File(absolutePath + "goodsImg\\" + uuidPath);
        if (!uploadPath.exists()){
            uploadPath.mkdirs();
        }

        int i = 1;  // 用于重命名图片名。从1开始
        for (MultipartFile file : files){
            //获取文件名 : file.getOriginalFilename(); 获取文件后缀：FilenameUtils.getExtension()
            //String uploadFileName = i++ + "." + FilenameUtils.getExtension(file.getOriginalFilename());
            String uploadFileName = i++ + ".jpg";

            //通过CommonsMultipartFile的方法直接写文件
            try{
                file.transferTo(new File(uploadPath + "\\" + uploadFileName));
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        return uuidPath;
    }

    /**
     * 创建与springboot打包的jar同级路径
     */
    public static void createDirIfNotExists() {
        if (!absolutePath.isEmpty()) return;

        //获取根目录
        String path;
        try {
            path = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("获取根目录失败，无法创建上传目录！");
        }
        absolutePath = path + uploadDir;

        File uploadPath = new File(absolutePath);
        if(!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
    }



}
