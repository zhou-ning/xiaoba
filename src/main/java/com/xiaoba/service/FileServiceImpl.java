package com.xiaoba.service;

import com.xiaoba.bean.Essay;
import com.xiaoba.mapper.EssayMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService{

    private Logger logger = (Logger) LoggerFactory.getLogger(getClass());

    @Value("${filepath}")
    private String filepath;

    @Autowired
    EssayMapper essayMapper;

    @Override
    public boolean upload(MultipartFile file) {
        // 获取原始名字
        String fileName = file.getOriginalFilename();

        // 文件重命名，防止重复,在这边先不判断文件是否重复
        //fileName = filepath + UUID.randomUUID() + fileName;
        fileName = filepath + fileName;
        System.out.println(fileName);
        logger.info("托盘存放位置"+fileName);

        // 文件对象
        File dest = new File(fileName);
        // 判断路径是否存在，如果不存在则创建
        if(!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        try {
            // 保存到服务器中
            file.transferTo(dest);
            return true;
        } catch (Exception e) {
            logger.error("文件上传错误:",e);
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String writeToHtml(String content,String title) {
        String fileName = title+".html";
        String pathName = filepath + fileName;
        try {
            PrintWriter pWriter = new PrintWriter(new FileOutputStream(new File(pathName)));
            pWriter.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "<link rel=\"stylesheet\" type=\"text/css\" href=\"hello.css\">\n" +
                    "\n" +
                    "\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>");
            //写下中间内容
            pWriter.println(content);
            pWriter.println("</body>\n" +
                    "</html>");
            pWriter.close();
            logger.info("编写了文章",pathName);
        } catch (FileNotFoundException e) {
            logger.error("存储为html文件错误:",e);
            e.printStackTrace();
        }

        Essay essay = new Essay();
        essay.setEssayTittle(title);
        essay.setEssayAbstract("andoiniopadsfpo");
        essay.setEssayAuthor("zhouning");
        essay.setEssayPublishTime(new Date());
        essay.setSavePath(fileName);
        System.out.println(essay);
//      essayMapper.insertEssay(essay);
        return pathName;
    }
}
