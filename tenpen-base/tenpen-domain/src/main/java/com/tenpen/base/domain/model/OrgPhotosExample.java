package com.tenpen.base.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgPhotosExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public OrgPhotosExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutIsNull() {
            addCriterion("total_collection_amout is null");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutIsNotNull() {
            addCriterion("total_collection_amout is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutEqualTo(Integer value) {
            addCriterion("total_collection_amout =", value, "totalCollectionAmout");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutNotEqualTo(Integer value) {
            addCriterion("total_collection_amout <>", value, "totalCollectionAmout");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutGreaterThan(Integer value) {
            addCriterion("total_collection_amout >", value, "totalCollectionAmout");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_collection_amout >=", value, "totalCollectionAmout");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutLessThan(Integer value) {
            addCriterion("total_collection_amout <", value, "totalCollectionAmout");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutLessThanOrEqualTo(Integer value) {
            addCriterion("total_collection_amout <=", value, "totalCollectionAmout");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutIn(List<Integer> values) {
            addCriterion("total_collection_amout in", values, "totalCollectionAmout");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutNotIn(List<Integer> values) {
            addCriterion("total_collection_amout not in", values, "totalCollectionAmout");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutBetween(Integer value1, Integer value2) {
            addCriterion("total_collection_amout between", value1, value2, "totalCollectionAmout");
            return (Criteria) this;
        }

        public Criteria andTotalCollectionAmoutNotBetween(Integer value1, Integer value2) {
            addCriterion("total_collection_amout not between", value1, value2, "totalCollectionAmout");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountIsNull() {
            addCriterion("total_preview_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountIsNotNull() {
            addCriterion("total_preview_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountEqualTo(Integer value) {
            addCriterion("total_preview_amount =", value, "totalPreviewAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountNotEqualTo(Integer value) {
            addCriterion("total_preview_amount <>", value, "totalPreviewAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountGreaterThan(Integer value) {
            addCriterion("total_preview_amount >", value, "totalPreviewAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_preview_amount >=", value, "totalPreviewAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountLessThan(Integer value) {
            addCriterion("total_preview_amount <", value, "totalPreviewAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountLessThanOrEqualTo(Integer value) {
            addCriterion("total_preview_amount <=", value, "totalPreviewAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountIn(List<Integer> values) {
            addCriterion("total_preview_amount in", values, "totalPreviewAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountNotIn(List<Integer> values) {
            addCriterion("total_preview_amount not in", values, "totalPreviewAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountBetween(Integer value1, Integer value2) {
            addCriterion("total_preview_amount between", value1, value2, "totalPreviewAmount");
            return (Criteria) this;
        }

        public Criteria andTotalPreviewAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("total_preview_amount not between", value1, value2, "totalPreviewAmount");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsWelfareIsNull() {
            addCriterion("is_welfare is null");
            return (Criteria) this;
        }

        public Criteria andIsWelfareIsNotNull() {
            addCriterion("is_welfare is not null");
            return (Criteria) this;
        }

        public Criteria andIsWelfareEqualTo(String value) {
            addCriterion("is_welfare =", value, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andIsWelfareNotEqualTo(String value) {
            addCriterion("is_welfare <>", value, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andIsWelfareGreaterThan(String value) {
            addCriterion("is_welfare >", value, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andIsWelfareGreaterThanOrEqualTo(String value) {
            addCriterion("is_welfare >=", value, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andIsWelfareLessThan(String value) {
            addCriterion("is_welfare <", value, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andIsWelfareLessThanOrEqualTo(String value) {
            addCriterion("is_welfare <=", value, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andIsWelfareLike(String value) {
            addCriterion("is_welfare like", value, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andIsWelfareNotLike(String value) {
            addCriterion("is_welfare not like", value, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andIsWelfareIn(List<String> values) {
            addCriterion("is_welfare in", values, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andIsWelfareNotIn(List<String> values) {
            addCriterion("is_welfare not in", values, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andIsWelfareBetween(String value1, String value2) {
            addCriterion("is_welfare between", value1, value2, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andIsWelfareNotBetween(String value1, String value2) {
            addCriterion("is_welfare not between", value1, value2, "isWelfare");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorIsNull() {
            addCriterion("last_updator is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorIsNotNull() {
            addCriterion("last_updator is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorEqualTo(String value) {
            addCriterion("last_updator =", value, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorNotEqualTo(String value) {
            addCriterion("last_updator <>", value, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorGreaterThan(String value) {
            addCriterion("last_updator >", value, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorGreaterThanOrEqualTo(String value) {
            addCriterion("last_updator >=", value, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorLessThan(String value) {
            addCriterion("last_updator <", value, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorLessThanOrEqualTo(String value) {
            addCriterion("last_updator <=", value, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorLike(String value) {
            addCriterion("last_updator like", value, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorNotLike(String value) {
            addCriterion("last_updator not like", value, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorIn(List<String> values) {
            addCriterion("last_updator in", values, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorNotIn(List<String> values) {
            addCriterion("last_updator not in", values, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorBetween(String value1, String value2) {
            addCriterion("last_updator between", value1, value2, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdatorNotBetween(String value1, String value2) {
            addCriterion("last_updator not between", value1, value2, "lastUpdator");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionIsNull() {
            addCriterion("last_update_version is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionIsNotNull() {
            addCriterion("last_update_version is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionEqualTo(Integer value) {
            addCriterion("last_update_version =", value, "lastUpdateVersion");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionNotEqualTo(Integer value) {
            addCriterion("last_update_version <>", value, "lastUpdateVersion");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionGreaterThan(Integer value) {
            addCriterion("last_update_version >", value, "lastUpdateVersion");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_update_version >=", value, "lastUpdateVersion");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionLessThan(Integer value) {
            addCriterion("last_update_version <", value, "lastUpdateVersion");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionLessThanOrEqualTo(Integer value) {
            addCriterion("last_update_version <=", value, "lastUpdateVersion");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionIn(List<Integer> values) {
            addCriterion("last_update_version in", values, "lastUpdateVersion");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionNotIn(List<Integer> values) {
            addCriterion("last_update_version not in", values, "lastUpdateVersion");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionBetween(Integer value1, Integer value2) {
            addCriterion("last_update_version between", value1, value2, "lastUpdateVersion");
            return (Criteria) this;
        }

        public Criteria andLastUpdateVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("last_update_version not between", value1, value2, "lastUpdateVersion");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table org_photos
     *
     * @mbggenerated do_not_delete_during_merge Wed Sep 25 16:05:01 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table org_photos
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}