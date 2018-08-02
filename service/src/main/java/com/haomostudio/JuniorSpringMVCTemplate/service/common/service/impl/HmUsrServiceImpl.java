package com.haomostudio.JuniorSpringMVCTemplate.service.common.service.impl;

import com.haomostudio.JuniorSpringMVCTemplate.dao.AuthTokenMapper;
import com.haomostudio.JuniorSpringMVCTemplate.dao.impl.HmUserDao;
import com.haomostudio.JuniorSpringMVCTemplate.po.AuthToken;
import com.haomostudio.JuniorSpringMVCTemplate.po.HmUser;
import com.haomostudio.JuniorSpringMVCTemplate.service.common.Response;
import com.haomostudio.JuniorSpringMVCTemplate.service.common.service.HmUsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 */
@Service(value = "hmUserService")
public class HmUsrServiceImpl implements HmUsrService {

    @Autowired
    HmUserDao hmUserDao;
    @Autowired
    AuthTokenMapper authTokenMapper;

    @Override
    public Map<String,Object> getUsr(HmUser user){
        List<HmUser> list = hmUserDao.getUsr(user);
        Response response = new Response();
        AuthToken authToken = null;
        if(null != list && list.size()>0){
            authToken = authTokenMapper.selectByPrimaryKey(list.get(0).getId());
        }
        Map<String,Object> map  = new HashMap<>();
        Map<String,Object> resultMap = new HashMap<>();
        map.put("id",list.get(0).getId());
        map.put("userId",list.get(0).getLoginid());
        map.put("token",authToken.getToken());
        map.put("createTime",authToken.getCreateTime());
        map.put("validTime",authToken.getValidTime());
        resultMap.put("code",0);
        resultMap.put("message","login success!");
        resultMap.put("token",map);
        return resultMap;
    }

}
