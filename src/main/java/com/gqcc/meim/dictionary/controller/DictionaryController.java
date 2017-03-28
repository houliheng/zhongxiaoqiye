package com.gqcc.meim.dictionary.controller;

import com.gqcc.meim.common.page.ResponseEntity;
import com.gqcc.meim.common.page.ResponseEntityUtil;
import com.gqcc.meim.common.web.BaseController;
import com.gqcc.meim.dictionary.service.DictionaryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hh on 2016/12/2.
 */
@RestController
@RequestMapping(value = "/mob/dictionary", produces = MediaType.APPLICATION_JSON_VALUE)
public class DictionaryController extends BaseController {
  @Resource
  DictionaryService dictionaryService;

  @RequestMapping(value = "/getDictParams", method = RequestMethod.GET)
  public ResponseEntity getDictParams(HttpServletRequest request, String dictParams, String sysId) {
    ResponseEntity responseEntity = dictionaryService.selectDictParamsByParams(dictParams, sysId);
    return responseEntity;
  }

  @RequestMapping(value = "/initDictionaryRedis", method = RequestMethod.GET)
  public ResponseEntity<Void> initDictionaryRedis(HttpServletRequest request) {
    dictionaryService.initSystemDictionaryCache();
    return ResponseEntityUtil.success();
  }

}
