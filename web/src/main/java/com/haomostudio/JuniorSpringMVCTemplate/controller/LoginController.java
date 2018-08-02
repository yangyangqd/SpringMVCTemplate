package com.haomostudio.JuniorSpringMVCTemplate.controller;

import com.haomostudio.JuniorSpringMVCTemplate.po.HmUser;
import com.haomostudio.JuniorSpringMVCTemplate.service.common.service.HmUsrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/2 0002.
 */
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HmUsrService hmService;


    @RequestMapping(value = "/account/login", method = RequestMethod.GET)
    @ResponseBody
    public Object login(HttpServletRequest request, HttpServletResponse response) {
        String loginId = request.getParameter("loginId").trim();
        String password = request.getParameter("password").trim();
        HmUser usr = new HmUser();
        usr.setId(loginId);
        usr.setPassword(password);
        Map<String,Object> result = hmService.getUsr(usr);
        return result;
    }
}
