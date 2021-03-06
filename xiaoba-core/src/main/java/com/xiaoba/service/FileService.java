package com.xiaoba.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhouning
 */
public interface FileService {
    /**
     * 上传文件
     * @param file
     * @return
     */
     boolean upload(MultipartFile file);

    /**
     * 将发送过来的 html内容转化为htnl文件存在服务器上
     * @param content
     * @param filename 文件名不需要带.md后缀
     * @return 在服务器上的地址
     */
     String writeToMd(String content,String filename);

    /**
     * 下载文章
     * @param request
     * @param response
     * @param fileName
     */
     void downloadFile(HttpServletRequest request, HttpServletResponse response, String fileName);

    /**
     *删除文章
     * @param fileName 文件名带有.md后缀
     */
    void deletFile(String fileName);
}
