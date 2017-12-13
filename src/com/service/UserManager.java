package com.service;

import com.dbtools.GetSqlSession;
import com.entity.User;
import com.entity.UserExample;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * Created by asus on 2017/12/12/012.
 */
public class UserManager {
    /**
     * 搜索员工信息
     * @param companyId 公司ID
     * @param key 关键词
     * @param order 排序依据
     * @param up 排序方式，0为升序，1为降序，否则为默认排序
     * @return
     * @throws IOException
     */
    public static List<User> selectUser(Integer companyId, String key, String order, Integer up) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        UserExample userExample = new UserExample();

        //关键字为空则搜索全部，否则根据关键字搜索
        if(key == null || key.length()!=0) {
            userExample.or().andCidEqualTo(companyId);
        } else {
            userExample.or().andCidEqualTo(companyId).andNameLike("%"+key+"%");
        }
        //设置升序降序或默认排序
        String sortWay;
        if(up == 0) {
            sortWay = " ASC";
            userExample.setOrderByClause(order+sortWay);

        } else if(up == 1) {
            sortWay = " DESC";
            userExample.setOrderByClause(order+sortWay);

        } else {

        }

        List<User> userList = sqlSession.selectList("com.dao.UserMapper.selectByExample", userExample);

        sqlSession.commit();
        sqlSession.close();
        return userList;
    }
}