package com.gqcc.meim.area.service;

import com.gqcc.meim.area.controller.res.AreaResponseForm;

import java.util.List;
import java.util.Map;

public interface AreaService {

  /**
   * 
   * @Title: initArea
   * @Description: 初始化数据到redis
   * @param
   * @return void
   *
   */
  void initArea();

  /**
   * 
   * @Title: getAllProvinces
   * @Description: 取得所有省数据
   * @return List<Area>
   *
   */
  public List<Map<Long, Object>> getAllProvinces();

  /**
   * 
   * @Title: getAllCitysByProvinceId
   * @Description: 根据省查询该省下的所有市列表
   * @param @param provinceId
   * @param @return
   * @return List<Area>
   *
   */
  public List<Map<Long, Object>> getAllCitysByProvinceId(Long provinceId);


  /**
   * 获取省下所有子节点
   * 
   * @param provinceId
   * @return
   */
  public List<Long> getChilderByProvinceId(List<Long> provinceId, Integer level,
      List<Long> listRet);

  /**
   * 获取所有孩子节点返回axis
   * 
   * @param ids
   * @param level
   * @param listRet
   * @return
   */
  public List<String> getChilderAxisByProvinceId(List<Long> ids, Integer level,
      List<String> listRet);

  /**
   * 
   * @Title: getAreaById
   * @Description: 根据id查询具体信息
   * @param areaId
   * @return Area
   *
   */
  public AreaResponseForm getAreaById(Long areaId);

  /**
   * 查询地区
   * 
   * @param axis
   * @return
   */
  public AreaResponseForm getAreaByAxis(String axis);
}
