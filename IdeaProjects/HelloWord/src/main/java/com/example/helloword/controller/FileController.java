package com.example.helloword.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileController {

    @RequestMapping("upload")
    public String fileText(String username, MultipartFile photo, HttpServletRequest request)throws IOException {
        // 姓名
        System.out.println("username：" + username);
        // 文件大小
        System.out.println("文件大小" + photo.getSize());
        // 文件类型
        System.out.println(photo.getContentType());
        // 文件原始名称
        System.out.println(photo.getOriginalFilename());

        // 动态获取web服务器路径目录
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(photo, path);
        return "上传成功";
    }

    private void saveFile(MultipartFile photo, String path)throws IOException {
        File upDir = new File(path);
        // 有无目录，无则创建
        if (!upDir.exists()){
            upDir .mkdir();
        }
        File file = new File(path + photo.getOriginalFilename());
        System.out.println("文件最终存储位置：" + path + photo.getOriginalFilename());
        photo.transferTo(file);
    }

}
