package com.xbl.webservice.controller;

import com.xbl.webservice.pojo.UserBean;
import com.xbl.webservice.utils.CreateTime;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@Api(tags = {"文件处理api"})
@RequestMapping("/user/file")
@Log4j2
public class FileController {
  @GetMapping("{id}")
  public void foo(@RequestBody UserBean user) {}
  // TODO: 2022/1/16 restapi
  @PostMapping()
  public String upload(@RequestParam("file") MultipartFile file) {
    if (file.isEmpty()) {
      return "上传失败，请选择文件";
    }
    String fileName = file.getOriginalFilename().trim();
    //    获取扩展名
    String exten = fileName.substring(fileName.indexOf("."), fileName.length());
    String filePath = "src/main/resources/upload/";
    File dest = new File(filePath+CreateTime.createTime() + exten);
    try {
      file.transferTo(dest.getAbsoluteFile());
      log.info("上传成功");
      return "上传成功" + dest;
    } catch (IOException e) {
      log.error("上传失败" + e.toString());
    }
    return "上传失败！";
  }
}
