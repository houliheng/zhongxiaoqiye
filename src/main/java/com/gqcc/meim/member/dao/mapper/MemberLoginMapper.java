package com.gqcc.meim.member.dao.mapper;

import com.gqcc.meim.member.dao.model.MemberLogin;
import com.gqcc.meim.member.dao.model.MemberLoginExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberLoginMapper {
    int countByExample(MemberLoginExample example);

    int deleteByExample(MemberLoginExample example);

    int deleteByPrimaryKey(Long boId);

    int insert(MemberLogin record);

    int insertSelective(MemberLogin record);

    List<MemberLogin> selectByExample(MemberLoginExample example);

    MemberLogin selectByPrimaryKey(Long boId);

    int updateByExampleSelective(@Param("record") MemberLogin record, @Param("example") MemberLoginExample example);

    int updateByExample(@Param("record") MemberLogin record, @Param("example") MemberLoginExample example);

    int updateByPrimaryKeySelective(MemberLogin record);

    int updateByPrimaryKey(MemberLogin record);
}