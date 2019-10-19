package com.tenpen.base.dao;

import com.tenpen.base.domain.model.OrgPhotosStatistics;
import com.tenpen.base.domain.model.OrgPhotosStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgPhotosStatisticsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_statistics
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int countByExample(OrgPhotosStatisticsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_statistics
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByExample(OrgPhotosStatisticsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_statistics
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_statistics
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insert(OrgPhotosStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_statistics
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insertSelective(OrgPhotosStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_statistics
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    List<OrgPhotosStatistics> selectByExample(OrgPhotosStatisticsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_statistics
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    OrgPhotosStatistics selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_statistics
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExampleSelective(@Param("record") OrgPhotosStatistics record, @Param("example") OrgPhotosStatisticsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_statistics
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExample(@Param("record") OrgPhotosStatistics record, @Param("example") OrgPhotosStatisticsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_statistics
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKeySelective(OrgPhotosStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_statistics
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKey(OrgPhotosStatistics record);
}