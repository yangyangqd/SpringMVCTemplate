package com.haomostudio.JuniorSpringMVCTemplate.controller;

import com.haomostudio.JuniorSpringMVCTemplate.po.AuthToken;
import com.haomostudio.JuniorSpringMVCTemplate.po.HmUser;
import com.haomostudio.JuniorSpringMVCTemplate.service.common.service.AuthTokenService;
import com.haomostudio.JuniorSpringMVCTemplate.service.common.service.HmUsrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2018/8/2 0002.
 */
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HmUsrService hmService;
    @Autowired
    private AuthTokenService authTokenService;


    @RequestMapping(value = "/hm_users/new", method = RequestMethod.GET)
    @ResponseBody
    public Object addUser(HttpServletRequest request, HttpServletResponse response,HmUser user) {
        String token = request.getParameter("X-Auth-Token").trim();
        AuthToken authToken = new AuthToken();
        authToken.setId(UUID.randomUUID().toString());
        authToken.setUserId(user.getId());
        authToken.setToken(token);
        authToken.setCreateTime(new Date());
        authToken.setValidTime(new Date());
        int n = hmService.insertSelective(user,authToken);
        return n;
    }
}
