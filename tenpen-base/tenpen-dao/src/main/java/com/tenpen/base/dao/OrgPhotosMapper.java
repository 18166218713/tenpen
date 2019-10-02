package com.tenpen.base.dao;

import com.tenpen.base.domain.model.OrgPhotos;
import com.tenpen.base.domain.model.OrgPhotosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgPhotosMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int countByExample(OrgPhotosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByExample(OrgPhotosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insert(OrgPhotos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insertSelective(OrgPhotos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    List<OrgPhotos> selectByExample(OrgPhotosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    OrgPhotos selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExampleSelective(@Param("record") OrgPhotos record, @Param("example") OrgPhotosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExample(@Param("record") OrgPhotos record, @Param("example") OrgPhotosExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKeySelective(OrgPhotos record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKey(OrgPhotos record);
}