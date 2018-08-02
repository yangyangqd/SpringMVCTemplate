package com.haomostudio.JuniorSpringMVCTemplate.dao.impl;


import com.haomostudio.JuniorSpringMVCTemplate.dao.AuthTokenMapper;
import com.haomostudio.JuniorSpringMVCTemplate.po.AuthToken;
import com.haomostudio.JuniorSpringMVCTemplate.po.AuthTokenExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;


/**
 * Created by shidaizhoukan on 2017/3/16.
 */
@Repository(value = "hmUserDao")
public class AuthTokenImpl implements AuthTokenMapper {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private DataSource dataSource;

    private JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Override
    public long countByExample(AuthTokenExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(AuthTokenExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(AuthToken record) {
        return 0;
    }

    @Override
    public int insertSelective(AuthToken record) {
        return 0;
    }

    @Override
    public List<AuthToken> selectByExampleWithRowbounds(AuthTokenExample example, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<AuthToken> selectByExample(AuthTokenExample example) {
        return null;
    }

    @Override
    public AuthToken selectByPrimaryKey(String id) {
        try {
            String sql = "select * from auth_token where user_id= ?";
            List e = null != id && "" != id ? this.getJdbcTemplate().queryForList(sql, id) :
                    this.getJdbcTemplate().queryForList(sql);
            return (AuthToken) e.get(0);
        } catch (Exception var4) {
            var4.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateByExampleSelective(@Param("record") AuthToken record, @Param("example") AuthTokenExample example) {
        return 0;
    }

    @Override
    public int updateByExample(@Param("record") AuthToken record, @Param("example") AuthTokenExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(AuthToken record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(AuthToken record) {
        return 0;
    }
}

