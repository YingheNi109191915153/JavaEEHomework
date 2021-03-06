package com.dao;

import com.entity.Cuser;
import com.entity.CuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CuserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cuser
     *
     * @mbg.generated Sun Dec 24 11:34:35 CST 2017
     */
    long countByExample(CuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cuser
     *
     * @mbg.generated Sun Dec 24 11:34:35 CST 2017
     */
    int deleteByExample(CuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cuser
     *
     * @mbg.generated Sun Dec 24 11:34:35 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cuser
     *
     * @mbg.generated Sun Dec 24 11:34:35 CST 2017
     */
    int insert(Cuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cuser
     *
     * @mbg.generated Sun Dec 24 11:34:35 CST 2017
     */
    int insertSelective(Cuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cuser
     *
     * @mbg.generated Sun Dec 24 11:34:35 CST 2017
     */
    List<Cuser> selectByExample(CuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cuser
     *
     * @mbg.generated Sun Dec 24 11:34:35 CST 2017
     */
    Cuser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cuser
     *
     * @mbg.generated Sun Dec 24 11:34:35 CST 2017
     */
    int updateByExampleSelective(@Param("record") Cuser record, @Param("example") CuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cuser
     *
     * @mbg.generated Sun Dec 24 11:34:35 CST 2017
     */
    int updateByExample(@Param("record") Cuser record, @Param("example") CuserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cuser
     *
     * @mbg.generated Sun Dec 24 11:34:35 CST 2017
     */
    int updateByPrimaryKeySelective(Cuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cuser
     *
     * @mbg.generated Sun Dec 24 11:34:35 CST 2017
     */
    int updateByPrimaryKey(Cuser record);

    void out(@Param("cid") Integer cid, @Param("ename") String ename, @Param("time") String time);
}