package com.xbl.webservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xbl.webservice.entity.Password;
import com.xbl.webservice.mapper.PasswordMapper;
import com.xbl.webservice.service.IPasswordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xbl.webservice.vo.UserVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author author
 * @since 2022-04-13
 */
@Service
@Log4j2
public class PasswordServiceImpl extends ServiceImpl<PasswordMapper, Password> implements IPasswordService {

    @Autowired
    PasswordMapper mapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean register(UserVo user) {
        if (findUser(user.getUname())) {
            log.info("该用户已经存在");
            return false;
        }

        Password newUser = new Password();
        newUser.setUname(user.getUname());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));


        System.out.println("newUser = " + newUser);
        int bool = mapper.insert(newUser);
        log.info(bool);
        if (bool == 1) return true;
        else return false;

    }

    @Override
    public boolean login(UserVo user) {
        boolean bool = findUser(user.getUname());
        return bool;
    }

    public boolean findUser(String uname) {

        QueryWrapper<Password> wrapper = new QueryWrapper<>();
        wrapper.eq("uname", uname);
        Password one = mapper.selectOne(wrapper);
        if (one != null) {
//            设置cookie 交给前端
            return true;
        }
        return false;
    }

    /**
     * @param uname
     * @return
     * @throws UsernameNotFoundException
     * @see com.xbl.webservice.config.securityConfig
     */
    @Override
    public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {

//        查找一个用户，
//        添加该用户的访问权限，
//        密码加密后由框架自动对比加密后的密码？？
        QueryWrapper<Password> wrapper = new QueryWrapper<>();
        wrapper.eq("uname", uname);
        Password one = mapper.selectOne(wrapper);
        if (one == null) {
            log.error("Error passwordServiceImpl line 83 没有找到该用户或selectone找到太多用户,uname=" + uname);
            throw new UsernameNotFoundException("not found");
        } else {
            ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            User userDetails = new User(one.getUname(),one.getPassword(), authorities);
            return userDetails;
        }


    }
}
