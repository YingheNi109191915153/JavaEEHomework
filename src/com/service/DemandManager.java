package com.service;

import com.dao.DemandMapper;
import com.dao.GoodsMapper;
import com.dbtools.GetSqlSession;
import com.entity.Demand;
import com.entity.DemandExample;
import com.entity.Demand;
import com.entity.Goods;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public static List<Demand> selectDemand(Integer companyId, String part, String key, String order, String up) throws IOException {
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        DemandExample demandExample = new DemandExample();

        //关键字为空则搜索全部，否则根据关键字搜索
        if (key == null || key.length() == 0) {
            if(part.equals("所有部门")) {
                demandExample.or().andCidEqualTo(companyId);
            } else {
                demandExample.or().andCidEqualTo(companyId).andPartEqualTo(part);
            }
        } else {
            if(part.equals("所有部门")) {
                demandExample.or().andCidEqualTo(companyId).andGnameLike("%" + key + "%");
            } else {
                demandExample.or().andCidEqualTo(companyId).andPartEqualTo(part).andGnameLike("%" + key + "%");
            }
        }
        //设置升序降序或默认排序
        if(!order.equals("default")) {
            String sortWay;
            if (up.equals("升序")) {
                sortWay = " ASC";
                demandExample.setOrderByClause(order + sortWay);
            } else if (up.equals("降序")) {
                sortWay = " DESC";
                demandExample.setOrderByClause(order + sortWay);
            } else {

            }
        }

        List<Demand> demandList = sqlSession.selectList("com.dao.DemandMapper.selectByExample", demandExample);

        sqlSession.commit();
        sqlSession.close();
        return demandList;
    }

    public static void doAddNewDemand(Integer cid, String gname, String classify, Integer need, String part) throws IOException {
        System.out.println("doAddNewDemand执行了");
        SqlSession sqlSession  = GetSqlSession.getSqlSession();
        DemandMapper mapper = sqlSession.getMapper(DemandMapper.class);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/beans.xml");
        Demand demand = (Demand) applicationContext.getBean("demand");
        demand.setCid(cid);
        demand.setGname(gname);
        demand.setClassify(classify);
        demand.setNeed(need);
        demand.setPart(part);

        mapper.insert(demand);

        sqlSession.commit();
        sqlSession.close();
    }
}
