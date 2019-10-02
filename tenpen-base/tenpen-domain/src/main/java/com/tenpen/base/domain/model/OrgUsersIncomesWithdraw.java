package com.tenpen.base.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrgUsersIncomesWithdraw {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.id
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.user_id
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.user_account
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private String userAccount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.user_name
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.status
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.amount
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.flow_no
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private String flowNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.withdraw_type
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private String withdrawType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.withdraw_time
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private Date withdrawTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.creator
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.create_time
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.last_updator
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private String lastUpdator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.last_update_time
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.last_update_version
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private Integer lastUpdateVersion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column org_users_incomes_withdraw.remark
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.id
     *
     * @return the value of org_users_incomes_withdraw.id
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.id
     *
     * @param id the value for org_users_incomes_withdraw.id
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.user_id
     *
     * @return the value of org_users_incomes_withdraw.user_id
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.user_id
     *
     * @param userId the value for org_users_incomes_withdraw.user_id
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.user_account
     *
     * @return the value of org_users_incomes_withdraw.user_account
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.user_account
     *
     * @param userAccount the value for org_users_incomes_withdraw.user_account
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.user_name
     *
     * @return the value of org_users_incomes_withdraw.user_name
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.user_name
     *
     * @param userName the value for org_users_incomes_withdraw.user_name
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.status
     *
     * @return the value of org_users_incomes_withdraw.status
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.status
     *
     * @param status the value for org_users_incomes_withdraw.status
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.amount
     *
     * @return the value of org_users_incomes_withdraw.amount
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.amount
     *
     * @param amount the value for org_users_incomes_withdraw.amount
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.flow_no
     *
     * @return the value of org_users_incomes_withdraw.flow_no
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public String getFlowNo() {
        return flowNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.flow_no
     *
     * @param flowNo the value for org_users_incomes_withdraw.flow_no
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo == null ? null : flowNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.withdraw_type
     *
     * @return the value of org_users_incomes_withdraw.withdraw_type
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public String getWithdrawType() {
        return withdrawType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.withdraw_type
     *
     * @param withdrawType the value for org_users_incomes_withdraw.withdraw_type
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setWithdrawType(String withdrawType) {
        this.withdrawType = withdrawType == null ? null : withdrawType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.withdraw_time
     *
     * @return the value of org_users_incomes_withdraw.withdraw_time
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public Date getWithdrawTime() {
        return withdrawTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.withdraw_time
     *
     * @param withdrawTime the value for org_users_incomes_withdraw.withdraw_time
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setWithdrawTime(Date withdrawTime) {
        this.withdrawTime = withdrawTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.creator
     *
     * @return the value of org_users_incomes_withdraw.creator
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.creator
     *
     * @param creator the value for org_users_incomes_withdraw.creator
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.create_time
     *
     * @return the value of org_users_incomes_withdraw.create_time
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.create_time
     *
     * @param createTime the value for org_users_incomes_withdraw.create_time
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.last_updator
     *
     * @return the value of org_users_incomes_withdraw.last_updator
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public String getLastUpdator() {
        return lastUpdator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.last_updator
     *
     * @param lastUpdator the value for org_users_incomes_withdraw.last_updator
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setLastUpdator(String lastUpdator) {
        this.lastUpdator = lastUpdator == null ? null : lastUpdator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.last_update_time
     *
     * @return the value of org_users_incomes_withdraw.last_update_time
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.last_update_time
     *
     * @param lastUpdateTime the value for org_users_incomes_withdraw.last_update_time
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.last_update_version
     *
     * @return the value of org_users_incomes_withdraw.last_update_version
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public Integer getLastUpdateVersion() {
        return lastUpdateVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.last_update_version
     *
     * @param lastUpdateVersion the value for org_users_incomes_withdraw.last_update_version
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setLastUpdateVersion(Integer lastUpdateVersion) {
        this.lastUpdateVersion = lastUpdateVersion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column org_users_incomes_withdraw.remark
     *
     * @return the value of org_users_incomes_withdraw.remark
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column org_users_incomes_withdraw.remark
     *
     * @param remark the value for org_users_incomes_withdraw.remark
     *
     * @mbggenerated Wed Sep 25 16:05:01 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}