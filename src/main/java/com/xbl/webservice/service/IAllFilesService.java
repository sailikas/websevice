package com.xbl.webservice.service;

import com.xbl.webservice.entity.AllFiles;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author author
 * @since 2022-04-13
 */
public interface IAllFilesService extends IService<AllFiles> {
    List UrlAllFiles(HttpServletRequest req);

    boolean upload(MultipartFile multipartFile, String URI, Integer type) throws IOException;
}
