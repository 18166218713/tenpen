package com.tenpen.base.dao;

import com.tenpen.base.domain.model.OrgProductsImages;
import com.tenpen.base.domain.model.OrgProductsImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgProductsImagesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_products_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int countByExample(OrgProductsImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_products_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByExample(OrgProductsImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_products_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_products_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insert(OrgProductsImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_products_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int insertSelective(OrgProductsImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_products_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    List<OrgProductsImages> selectByExample(OrgProductsImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_products_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    OrgProductsImages selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_products_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExampleSelective(@Param("record") OrgProductsImages record, @Param("example") OrgProductsImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_products_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByExample(@Param("record") OrgProductsImages record, @Param("example") OrgProductsImagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_products_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKeySelective(OrgProductsImages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_products_images
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    int updateByPrimaryKey(OrgProductsImages record);
}