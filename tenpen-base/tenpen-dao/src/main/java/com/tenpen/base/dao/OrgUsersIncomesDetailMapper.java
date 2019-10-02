package com.tenpen.base.dao;

import com.tenpen.base.domain.model.OrgUsersIncomesDetail;
import com.tenpen.base.domain.model.OrgUsersIncomesDetailExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrgUsersIncomesDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_incomes_detail
     *
     * @mbggenerated Thu Sep 26 16:58:13 CST 2019
     */
    int countByExample(OrgUsersIncomesDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_incomes_detail
     *
     * @mbggenerated Thu Sep 26 16:58:13 CST 2019
     */
    int deleteByExample(OrgUsersIncomesDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_incomes_detail
     *
     * @mbggenerated Thu Sep 26 16:58:13 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_incomes_detail
     *
     * @mbggenerated Thu Sep 26 16:58:13 CST 2019
     */
    int insert(OrgUsersIncomesDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_incomes_detail
     *
     * @mbggenerated Thu Sep 26 16:58:13 CST 2019
     */
    int insertSelective(OrgUsersIncomesDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_incomes_detail
     *
     * @mbggenerated Thu Sep 26 16:58:13 CST 2019
     */
    List<OrgUsersIncomesDetail> selectByExample(OrgUsersIncomesDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_incomes_detail
     *
     * @mbggenerated Thu Sep 26 16:58:13 CST 2019
     */
    OrgUsersIncomesDetail selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_incomes_detail
     *
     * @mbggenerated Thu Sep 26 16:58:13 CST 2019
     */
    int updateByExampleSelective(@Param("record") OrgUsersIncomesDetail record, @Param("example") OrgUsersIncomesDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_incomes_detail
     *
     * @mbggenerated Thu Sep 26 16:58:13 CST 2019
     */
    int updateByExample(@Param("record") OrgUsersIncomesDetail record, @Param("example") OrgUsersIncomesDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_incomes_detail
     *
     * @mbggenerated Thu Sep 26 16:58:13 CST 2019
     */
    int updateByPrimaryKeySelective(OrgUsersIncomesDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_incomes_detail
     *
     * @mbggenerated Thu Sep 26 16:58:13 CST 2019
     */
    int updateByPrimaryKey(OrgUsersIncomesDetail record);

    /**
     * 分页查询
     *
     * @param queryMap 查询条件
     * @return
     */
    List<OrgUsersIncomesDetail> selectIncomesByPage(Map<String, Object> queryMap);
}