package com.xbl.webservice.service;

import com.xbl.webservice.entity.Password;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xbl.webservice.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2022-04-13
 */
public interface IPasswordService extends IService<Password> , UserDetailsService {

    boolean register(UserVo user);

    boolean login(UserVo user);
}
