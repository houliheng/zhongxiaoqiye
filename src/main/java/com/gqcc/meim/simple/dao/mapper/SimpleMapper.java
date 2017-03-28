package com.gqcc.meim.simple.dao.mapper;

import com.gqcc.meim.simple.dao.model.Simple;
import com.gqcc.meim.simple.dao.model.SimpleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimpleMapper {
    int countByExample(SimpleExample example);

    int deleteByExample(SimpleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Simple record);

    int insertSelective(Simple record);

    List<Simple> selectByExample(SimpleExample example);

    Simple selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Simple record, @Param("example") SimpleExample example);

    int updateByExample(@Param("record") Simple record, @Param("example") SimpleExample example);

    int updateByPrimaryKeySelective(Simple record);

    int updateByPrimaryKey(Simple record);
}