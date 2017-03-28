package com.gqcc.meim.dictionary.dao.mapper;

import com.gqcc.meim.dictionary.dao.model.DictionaryItem;
import com.gqcc.meim.dictionary.dao.model.DictionaryItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictionaryItemMapper {
    int countByExample(DictionaryItemExample example);

    int deleteByExample(DictionaryItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DictionaryItem record);

    int insertSelective(DictionaryItem record);

    List<DictionaryItem> selectByExample(DictionaryItemExample example);

    DictionaryItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DictionaryItem record, @Param("example") DictionaryItemExample example);

    int updateByExample(@Param("record") DictionaryItem record, @Param("example") DictionaryItemExample example);

    int updateByPrimaryKeySelective(DictionaryItem record);

    int updateByPrimaryKey(DictionaryItem record);
}