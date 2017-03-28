package com.gqcc.meim.area.controller;

import com.gqcc.meim.area.controller.res.AreaResponseForm;
import com.gqcc.meim.area.service.AreaService;
import com.gqcc.meim.common.page.ResponseEntity;
import com.gqcc.meim.common.page.ResponseEntityUtil;
import com.gqcc.meim.common.web.BaseController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/area/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AreaController extends BaseController {
  @Resource
  AreaService areaService;

  @RequestMapping(value = "/init", method = RequestMethod.GET)
  public ResponseEntity<?> init(HttpServletRequest request) throws Exception {
    areaService.initArea();
    return ResponseEntityUtil.success();
  }

  @RequestMapping(value = "/getAllProvinces", method = RequestMethod.GET)
  public ResponseEntity<?> getAllProvinces(HttpServletRequest request) throws Exception {
    List<Map<Long, Object>> list = areaService.getAllProvinces();
    return ResponseEntityUtil.success(list);
  }

  @RequestMapping(value = "/getAllCitysByProvinceId/{areaId}", method = RequestMethod.GET)
  public ResponseEntity<?> getAllCitysByProvinceId(@PathVariable("areaId") Long areaId,
      HttpServletRequest request) throws Exception {
    List<Map<Long, Object>> list = areaService.getAllCitysByProvinceId(areaId);
    return ResponseEntityUtil.success(list);
  }

  @RequestMapping(value = "/getAreaById/{areaId}", method = RequestMethod.GET)
  public ResponseEntity<?> getAllProvinces(@PathVariable("areaId") Long areaId,
      HttpServletRequest request) throws Exception {
    AreaResponseForm area = areaService.getAreaById(areaId);
    return ResponseEntityUtil.success(area);
  }
}
