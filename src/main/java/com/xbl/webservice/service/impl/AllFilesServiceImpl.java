package com.xbl.webservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xbl.webservice.entity.AllFiles;
import com.xbl.webservice.mapper.AllFilesMapper;
import com.xbl.webservice.service.IAllFilesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xbl.webservice.utils.FileUpLoadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2022-04-13
 */
@Service
public class AllFilesServiceImpl extends ServiceImpl<AllFilesMapper, AllFiles> implements IAllFilesService {

    @Autowired
    AllFilesMapper mapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List UrlAllFiles(HttpServletRequest req) {
//        System.out.println("req.getRequestURI() = " + req.getRequestURI());
        String URI = req.getRequestURI();
//        System.out.println("req.getCookies() = " + req.getCookies());
        // TODO: 2022/4/13 校验cookie
//        cookie校验是否有权限访问 uid相等就可以
//        查询path等于 /uid/fid 的所有数据
        QueryWrapper<AllFiles> wrapper = new QueryWrapper<>();
        wrapper.eq("file_path", URI);
        return mapper.selectList(wrapper);
    }

    @Override
    public boolean upload(MultipartFile multipartFile, String URI, Integer type) throws IOException {

        String name = multipartFile.getOriginalFilename();
        String sub = name.substring(name.lastIndexOf("."));
        String fileName = UUID.randomUUID() + sub;

        AllFiles files = new AllFiles();
        files.setFileName(fileName);
        files.setFilePath(URI);
        files.setFileSize((int) multipartFile.getSize());
        files.setFileType(type);

        mapper.insert(files);
        return FileUpLoadUtils.upload(fileName, multipartFile);

    }
}
