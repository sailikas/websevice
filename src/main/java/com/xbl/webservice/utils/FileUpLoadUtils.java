package com.xbl.webservice.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.UUID;

@Log4j2
public class FileUpLoadUtils {


    public static boolean upload(String fileName ,MultipartFile multipartFile) throws IOException {

        log.error(PathUtiles.classpath());
        File dest = new File(PathUtiles.classpath()+"/upload/" + fileName);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        log.info(dest.getPath());
        multipartFile.transferTo(dest);

        return true;
//        log.error("ALLFileService upload 不知道为啥文件没创建成功");
//        return false;
    }

}
