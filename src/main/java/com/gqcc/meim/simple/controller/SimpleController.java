package com.gqcc.meim.simple.controller;

import com.gqcc.meim.common.interceptor.SysAuthority;
import com.gqcc.meim.common.interceptor.SysAuthority.PrivilegeLevel;
import com.gqcc.meim.common.page.ResponseEntity;
import com.gqcc.meim.common.page.ResponseEntityUtil;
import com.gqcc.meim.common.page.ResponsePagesEntityUtil;
import com.gqcc.meim.common.web.BaseController;
import com.gqcc.meim.simple.controller.req.SimpleReqForm;
import com.gqcc.meim.simple.controller.res.SimpleResForm;
import com.gqcc.meim.simple.dao.model.Simple;
import com.gqcc.meim.simple.service.SimpleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "示例代码", description = "示例代码")
@RestController
@RequestMapping(value = "/simple", produces = MediaType.APPLICATION_JSON_VALUE)
public class SimpleController extends BaseController {
  @Resource
  SimpleService simpleService;

  @ApiOperation(value = "查询单个实体", notes = "查询单个实体", response = SimpleResForm.class)
  @RequestMapping(value = "/selectSimpleById/{id}", method = RequestMethod.GET)
  public Object selectSimpleList(@PathVariable("id") Long id) throws Exception {
    SimpleResForm simpleResForm = simpleService.selectSimpleById(id);
    return simpleResForm;
  }

  @ApiOperation(value = "查询列表", notes = "查询列表")
  @RequestMapping(value = "/selectSimpleList", method = RequestMethod.POST)
  @SysAuthority(moduleName = "简单", level = PrivilegeLevel.ALL_PRIVILEGE)
  public ResponsePagesEntityUtil<?> selectSimpleList(@RequestBody SimpleReqForm reqForm) {
    List<Simple> list = simpleService.selectSimpleList(reqForm);
    return ResponseEntityUtil.successPages(list);
  }

  @ApiOperation(value = "更新", notes = "更新")
  @RequestMapping(value = "/updateSimple", method = RequestMethod.POST)
  public void updateSimple(SimpleReqForm reqForm) throws Exception {
    simpleService.updateSimpleEntity(reqForm);
  }

  @ApiOperation(value = "插入", notes = "插入")
  @RequestMapping(value = "/insertSimple", method = RequestMethod.GET)
  public ResponseEntity<Void> insertSimple(SimpleReqForm reqForm) throws Exception {
    simpleService.insertSimpleEntity(reqForm);
    return ResponseEntityUtil.success();
  }

  @ApiOperation(value = "删除", notes = "删除")
  @RequestMapping(value = "/deleteSimpleById/{id}", method = RequestMethod.GET)
  public ResponseEntity<Void> deleteSimpleById(@PathVariable("id") Long id) throws Exception {
    simpleService.deleteSimpleById(id);
    return ResponseEntityUtil.success();
  }
}
