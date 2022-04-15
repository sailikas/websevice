package com.xbl.webservice.controller;


import com.xbl.webservice.service.impl.AllFilesServiceImpl;
import com.xbl.webservice.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author author
 * @since 2022-04-13
 */
@RestController
@RequestMapping("file")
public class AllFilesController {

    @Autowired
    AllFilesServiceImpl fs;

    @GetMapping("{uid}/{fid}")
    public Result test(HttpServletRequest request, HttpServletResponse response) {
        List data = fs.UrlAllFiles(request);
        return Result.success(data);
    }

    @PostMapping("/upload")
    @Transactional(rollbackFor = Exception.class)
    public Result add(@RequestPart MultipartFile multipartFile,
                      HttpServletRequest request,
                      @RequestParam("type")Integer type) throws IOException {

        if (fs.upload(multipartFile, request.getRequestURI(), type)) {
            return Result.success(null);
        }
        return Result.failed(null);

    }


}
