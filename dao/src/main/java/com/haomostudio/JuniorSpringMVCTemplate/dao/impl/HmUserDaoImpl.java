package com.haomostudio.JuniorSpringMVCTemplate.dao.impl;


import com.haomostudio.JuniorSpringMVCTemplate.dao.HmUserMapper;
import com.haomostudio.JuniorSpringMVCTemplate.po.HmUser;
import com.haomostudio.JuniorSpringMVCTemplate.po.HmUserExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by shidaizhoukan on 2017/3/16.
 */
@Repository(value = "hmUserDao")
public class HmUserDaoImpl implements HmUserMapper {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataSource dataSource;

    @Override
    public long countByExample(HmUserExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(HmUserExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(HmUser record) {
        return 0;
    }

    @Override
    public int insertSelective(HmUser record) {
        return 0;
    }

    @Override
    public List<HmUser> selectByExampleWithRowbounds(HmUserExample example, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<HmUser> selectByExample(HmUserExample example) {
        return null;
    }

    @Override
    public List<HmUser> getUsr(HmUser user){
        try {
            String sql = "select * from hm_user where loginid= ? and password = ?";
            List e = null != user ? this.getJdbcTemplate().queryForList(sql, user) :
                    this.getJdbcTemplate().queryForList(sql);
            return e;
        } catch (Exception var4) {
            var4.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public HmUser selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByExampleSelective(@Param("record") HmUser record, @Param("example") HmUserExample example) {
        return 0;
    }

    @Override
    public int updateByExample(@Param("record") HmUser record, @Param("example") HmUserExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(HmUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(HmUser record) {
        return 0;
    }

    public List<HmUser> queryForList(String sql, List<Object> params) {
        try {
            List e = params.size() > 0 ? this.getJdbcTemplate().queryForList(sql, params.toArray()) :
                    this.getJdbcTemplate().queryForList(sql);
            return e;
        } catch (Exception var4) {
            var4.printStackTrace();
            return new ArrayList<>();
        }
    }

    private JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

}

