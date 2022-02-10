package com.xbl.webservice.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xbl.webservice.mapper.AdminMapper;
import com.xbl.webservice.pojo.AdminBean;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminBean>implements AdminService {
}
