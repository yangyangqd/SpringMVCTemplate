package com.haomostudio.JuniorSpringMVCTemplate.service.common.service;


import com.haomostudio.JuniorSpringMVCTemplate.po.HmUser;

import java.util.Map;

public interface HmUsrService {
	Map<String,Object> getUsr(HmUser usr);
}