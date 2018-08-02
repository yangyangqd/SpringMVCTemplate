package com.haomostudio.JuniorSpringMVCTemplate.service.common.service;


import com.haomostudio.JuniorSpringMVCTemplate.po.AuthToken;

public interface AuthTokenService {
	int insertSelective(AuthToken record);
}