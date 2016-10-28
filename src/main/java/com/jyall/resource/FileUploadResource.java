package com.jyall.resource;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by wang.linqiao on 2016/10/20.
 */
@Controller
public class FileUploadResource {

    private Logger logger = LoggerFactory.getLogger(FileUploadResource.class);

    @ApiOperation(value ="上传单个文件",notes = "")
    @ApiImplicitParam(name = "file",value = "要上传的文件",required = true,dataType = "File.class")
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@PathParam(value = "file")MultipartFile file){
        try {
            String originalFilename = file.getOriginalFilename();
            String uuidName = UUID.randomUUID().toString();
            File dir = new File("F:\\pic\\"+uuidName+originalFilename.substring(originalFilename.lastIndexOf(".")));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dir));
            out.write(file.getBytes());
            out.close();
            logger.info("文件上传成功！");
            return "上传文件成功！";
        } catch (IOException e) {
            logger.error("上传文件失败！",e);
            e.printStackTrace();
            return "上传文件失败！";
        }
    }

    @RequestMapping("/toUpload")
    public String toUpload(){
        return "/file";
    }

    @RequestMapping("/batch/toUpload")
    public String toUploads(){ return  "/mutifile";}

    @RequestMapping(value = "/batch/upload",method = RequestMethod.POST)
    @ResponseBody
    public String uploads(HttpServletRequest request){
        List<MultipartFile> files=((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file=null;
        for (int i=0;i<files.size();i++){
            try {
                file=files.get(i);
                String originalFilename = file.getOriginalFilename();
                String uuidName = UUID.randomUUID().toString();
                File dir = new File("F:\\pic\\"+uuidName+originalFilename.substring(originalFilename.lastIndexOf(".")));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dir));
                out.write(file.getBytes());
                out.close();
            } catch (IOException e) {
                logger.info("文件"+i+"上传失败！",e);
            }
        }
        return "文件上传成功！";
    }
}
