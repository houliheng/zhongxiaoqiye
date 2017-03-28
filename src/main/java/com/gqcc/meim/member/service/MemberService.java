package com.gqcc.meim.member.service;

import com.gqcc.meim.common.exception.business.BusinessException;
import com.gqcc.meim.member.dao.model.Member;

public interface MemberService {

  Member selMemberByBoId(Long boId) throws BusinessException;
}
