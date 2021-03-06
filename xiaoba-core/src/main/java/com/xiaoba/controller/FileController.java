package com.xiaoba.controller;

import com.xiaoba.constans.PathContants;
import com.xiaoba.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author zhouning
 */
@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileService fileService;



    @RequestMapping("/")
    public String index(){
        return "upload";
    }

    private String url = "http://39.99.203.80:8080/images/";


    /**
     * 上传文件
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload (@RequestParam("file") MultipartFile file) {

        boolean result = fileService.upload(file);
        if (result){
            return PathContants.IMG_PATH +file.getOriginalFilename();
        }
        return "上传失败";
    }


    /**
     * 下载文件
     * @param request
     * @param response
     */
    @RequestMapping("/download")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response,String fileName) {
        fileService.downloadFile(request, response, fileName);
    }

}
