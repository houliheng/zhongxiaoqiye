package com.gqcc.meim.member.service.impl;

import com.gqcc.meim.common.exception.business.BusinessException;
import com.gqcc.meim.member.dao.mapper.MemberMapper;
import com.gqcc.meim.member.dao.model.Member;
import com.gqcc.meim.member.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberServiceImpl implements MemberService {
  static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
  @Resource
  MemberMapper memberMapper;

  @Override
  public Member selMemberByBoId(Long boId) throws BusinessException {
    return memberMapper.selectByPrimaryKey(boId);
  }
}
