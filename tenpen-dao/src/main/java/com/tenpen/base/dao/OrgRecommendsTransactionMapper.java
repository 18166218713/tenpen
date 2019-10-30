package com.tenpen.base.dao;

import com.tenpen.base.domain.model.OrgRecommendsTransaction;
import com.tenpen.base.domain.model.OrgRecommendsTransactionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgRecommendsTransactionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_recommends_transaction
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int countByExample(OrgRecommendsTransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_recommends_transaction
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByExample(OrgRecommendsTransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_recommends_transaction
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_recommends_transaction
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insert(OrgRecommendsTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_recommends_transaction
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insertSelective(OrgRecommendsTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_recommends_transaction
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    List<OrgRecommendsTransaction> selectByExample(OrgRecommendsTransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_recommends_transaction
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    OrgRecommendsTransaction selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_recommends_transaction
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExampleSelective(@Param("record") OrgRecommendsTransaction record, @Param("example") OrgRecommendsTransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_recommends_transaction
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExample(@Param("record") OrgRecommendsTransaction record, @Param("example") OrgRecommendsTransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_recommends_transaction
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKeySelective(OrgRecommendsTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_recommends_transaction
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKey(OrgRecommendsTransaction record);
}