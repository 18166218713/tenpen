package com.tenpen.base.dao;

import com.tenpen.base.domain.model.OrgUsersLogin;
import com.tenpen.base.domain.model.OrgUsersLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgUsersLoginMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_login
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int countByExample(OrgUsersLoginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_login
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByExample(OrgUsersLoginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_login
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_login
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insert(OrgUsersLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_login
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insertSelective(OrgUsersLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_login
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    List<OrgUsersLogin> selectByExample(OrgUsersLoginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_login
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    OrgUsersLogin selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_login
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExampleSelective(@Param("record") OrgUsersLogin record, @Param("example") OrgUsersLoginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_login
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExample(@Param("record") OrgUsersLogin record, @Param("example") OrgUsersLoginExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_login
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKeySelective(OrgUsersLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_users_login
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKey(OrgUsersLogin record);
}