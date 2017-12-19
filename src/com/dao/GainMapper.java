package com.dao;

import com.entity.Gain;
import com.entity.GainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GainMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gain
     *
     * @mbg.generated Sun Dec 17 18:35:48 CST 2017
     */
    long countByExample(GainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gain
     *
     * @mbg.generated Sun Dec 17 18:35:48 CST 2017
     */
    int deleteByExample(GainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gain
     *
     * @mbg.generated Sun Dec 17 18:35:48 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gain
     *
     * @mbg.generated Sun Dec 17 18:35:48 CST 2017
     */
    int insert(Gain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gain
     *
     * @mbg.generated Sun Dec 17 18:35:48 CST 2017
     */
    int insertSelective(Gain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gain
     *
     * @mbg.generated Sun Dec 17 18:35:48 CST 2017
     */
    List<Gain> selectByExample(GainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gain
     *
     * @mbg.generated Sun Dec 17 18:35:48 CST 2017
     */
    Gain selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gain
     *
     * @mbg.generated Sun Dec 17 18:35:48 CST 2017
     */
    int updateByExampleSelective(@Param("record") Gain record, @Param("example") GainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gain
     *
     * @mbg.generated Sun Dec 17 18:35:48 CST 2017
     */
    int updateByExample(@Param("record") Gain record, @Param("example") GainExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gain
     *
     * @mbg.generated Sun Dec 17 18:35:48 CST 2017
     */
    int updateByPrimaryKeySelective(Gain record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gain
     *
     * @mbg.generated Sun Dec 17 18:35:48 CST 2017
     */
    int updateByPrimaryKey(Gain record);
}