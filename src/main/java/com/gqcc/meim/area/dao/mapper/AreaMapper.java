package com.gqcc.meim.area.dao.mapper;

import com.gqcc.meim.area.controller.res.AreaResponseForm;
import com.gqcc.meim.area.dao.model.Area;
import com.gqcc.meim.area.dao.model.AreaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {
    int countByExample(AreaExample example);

    int deleteByExample(AreaExample example);

    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    int insertSelective(Area record);

    List<Area> selectByExample(AreaExample example);

    Area selectByPrimaryKey(Integer areaId);

    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
    /**
     *
     * @Title: selectAreaListByExample
     * @Description: 返回列表
     * @param example
     * @return List<AreaResponseForm>
     *
     */
    List<AreaResponseForm> selectAreaListByExample(AreaExample example);
}