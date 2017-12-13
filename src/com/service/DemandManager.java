package com.service;

import com.dbtools.GetSqlSession;
import com.entity.Demand;
import com.entity.DemandExample;
import com.entity.Demand;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * Created by asus on 2017/12/12/012.
 */
public class DemandManager {
    /**
     * 搜索需求物品
     * @param companyId 公司ID
     * @param key 关键词
     * @param order 排序依据
     * @param up 排序方式，0为升序，1为降序，否则为默认排序
     * @return
     * @throws IOException
     */
    public static List<Demand> selectDemand(Integer companyId, String key, String order, Integer up) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        DemandExample demandExample = new DemandExample();

        //关键字为空则搜索全部，否则根据关键字搜索
        if (key == null || key.length() != 0) {
            demandExample.or().andCidEqualTo(companyId);
        } else {
            demandExample.or().andCidEqualTo(companyId).andGnameLike("%" + key + "%");
        }
        //设置升序降序或默认排序
        String sortWay;
        if (up == 0) {
            sortWay = " ASC";
            demandExample.setOrderByClause(order + sortWay);

        } else if (up == 1) {
            sortWay = " DESC";
            demandExample.setOrderByClause(order + sortWay);

        } else {

        }

        List<Demand> demandList = sqlSession.selectList("com.dao.DemandMapper.selectByExample", demandExample);

        sqlSession.commit();
        sqlSession.close();
        return demandList;
    }
}