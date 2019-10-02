package com.tenpen.base.dao;

import com.tenpen.base.domain.model.OrgModifyPassword;
import com.tenpen.base.domain.model.OrgModifyPasswordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgModifyPasswordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_modify_password
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int countByExample(OrgModifyPasswordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_modify_password
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByExample(OrgModifyPasswordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_modify_password
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_modify_password
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insert(OrgModifyPassword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_modify_password
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insertSelective(OrgModifyPassword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_modify_password
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    List<OrgModifyPassword> selectByExample(OrgModifyPasswordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_modify_password
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    OrgModifyPassword selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_modify_password
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExampleSelective(@Param("record") OrgModifyPassword record, @Param("example") OrgModifyPasswordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_modify_password
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExample(@Param("record") OrgModifyPassword record, @Param("example") OrgModifyPasswordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_modify_password
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKeySelective(OrgModifyPassword record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_modify_password
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKey(OrgModifyPassword record);
}