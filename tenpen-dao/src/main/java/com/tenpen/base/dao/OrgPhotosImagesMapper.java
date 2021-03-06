package com.tenpen.base.dao;

import com.tenpen.base.domain.model.OrgPhotosImages;
import com.tenpen.base.domain.model.OrgPhotosImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgPhotosImagesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int countByExample(OrgPhotosImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByExample(OrgPhotosImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insert(OrgPhotosImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insertSelective(OrgPhotosImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    List<OrgPhotosImages> selectByExample(OrgPhotosImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    OrgPhotosImages selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExampleSelective(@Param("record") OrgPhotosImages record, @Param("example") OrgPhotosImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExample(@Param("record") OrgPhotosImages record, @Param("example") OrgPhotosImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKeySelective(OrgPhotosImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKey(OrgPhotosImages record);
}