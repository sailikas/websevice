package com.xbl.webservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xbl.webservice.pojo.AdminBean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xbl.webservice.mapper.AdminMapper;
import com.xbl.webservice.service.AdminServiceImpl;
import java.util.HashMap;
import java.util.List;

@Api(tags={"admin操作接口"})
@RestController
@RequestMapping("admin")

public class AdminController {
  @Autowired
  AdminMapper mapper;

  @Autowired
  AdminServiceImpl adminSevice;

  @GetMapping("service")
  @ApiOperation(value="根据用户编号获取用户姓名", notes="test: 仅1和2有正确返回")

  public List<AdminBean> foo3() {
    return adminSevice.list();
  }

  @GetMapping("add")
  public int insert() {
    final AdminBean admin = new AdminBean();
    admin.setName("333");
    admin.setPassword("1235");

    return mapper.insert(admin);
  }

  @GetMapping("find")
  public List<AdminBean> find() {
    final QueryWrapper<AdminBean> wrapper = new QueryWrapper<>();
    wrapper.lt("name", "2000");
    return mapper.selectList(wrapper);
  }

  @GetMapping("limit")
  public List<AdminBean> limit() {
    Page<AdminBean> page = new Page<>(1, 3);
    mapper.selectPage(page, null);

    return page.getRecords();
  }

  @GetMapping("lock")
  public void happy() {
    final AdminBean adminBean = mapper.selectById("1476171515178348546");
    adminBean.setName("ver测试");
    adminBean.setPassword("777");

    final AdminBean adminBean2 = mapper.selectById("1476171515178348546");
    adminBean2.setName("ver测试");
    adminBean2.setPassword("888");

    mapper.updateById(adminBean);
    mapper.updateById(adminBean2);
  }

  @GetMapping("findall")
  public List<AdminBean> findall() {
    return mapper.selectList(null);
  }

  @GetMapping("del")
  public String delete() {
    final HashMap<String, Object> map = new HashMap<>();
    map.put("name", "777");
    mapper.deleteByMap(map);
    return "成功删除";
  }
}
