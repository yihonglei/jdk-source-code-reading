package com.lanhuigu.jvm;

import java.util.Date;

/**
 * 签约流水
 * @author yihonglei
 * @date 2018/8/15 11:40
 */
public class BankContractFlow {
    /** 主键 */
    private Long bfcId;
    /** 业务序列号 */
    private String bcfBizSequenceCode;
    /** 通道序列号 */
    private String bcfChannelSequenceCode;
    /** 业务类型：申请 1, 确认 2 */
    private Byte bcfBizType;
    /** 银行卡号 */
    private String bcfCardNo;
    /** 持卡人姓名 */
    private String bcfHolder;
    /** 证件类型 */
    private String bcfCredentialsType;
    /** 证件号 */
    private String bcfCredentialsNumber;
    /** 银行预留手机号 */
    private String bcfMobileNumber;
    /** 通道编码 */
    private String bcfChannelCode;
    /** 通道名称 */
    private String bcfChannelName;
    /** 银行编号 */
    private Integer bcfBankCode;
    /** 银行名称 */
    private String bcfBankName;
    /** 业务渠道（预留字段） */
    private String bcfBizChannel;
    /** 状态：10 初始, 40处理中， 80成功， 85 失败 */
    private Byte bcfStatus;
    /** 响应码 */
    private String bcfResponseCode;
    /** 响应说明 */
    private String bcfResponseDesc;
    /** 签约附加码 */
    private String bcfAdditionalCode;
    /** 标识（预留字段） */
    private String bcfMark;
    /** 更新时间 */
    private Date bcfModifyTime;
    /** 创建时间 */
    private Date bcfCreateTime;

    public enum Status {
        INIT("10"),
        DEALING("40"),
        SUCCESS("80"),
        FAIL("85");

        private String value;

        Status(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public Long getBfcId() {
        return bfcId;
    }

    public void setBfcId(Long bfcId) {
        this.bfcId = bfcId;
    }

    public String getBcfBizSequenceCode() {
        return bcfBizSequenceCode;
    }

    public void setBcfBizSequenceCode(String bcfBizSequenceCode) {
        this.bcfBizSequenceCode = bcfBizSequenceCode;
    }

    public String getBcfChannelSequenceCode() {
        return bcfChannelSequenceCode;
    }

    public void setBcfChannelSequenceCode(String bcfChannelSequenceCode) {
        this.bcfChannelSequenceCode = bcfChannelSequenceCode;
    }

    public Byte getBcfBizType() {
        return bcfBizType;
    }

    public void setBcfBizType(Byte bcfBizType) {
        this.bcfBizType = bcfBizType;
    }

    public String getBcfCardNo() {
        return bcfCardNo;
    }

    public void setBcfCardNo(String bcfCardNo) {
        this.bcfCardNo = bcfCardNo;
    }

    public String getBcfHolder() {
        return bcfHolder;
    }

    public void setBcfHolder(String bcfHolder) {
        this.bcfHolder = bcfHolder;
    }

    public String getBcfCredentialsType() {
        return bcfCredentialsType;
    }

    public void setBcfCredentialsType(String bcfCredentialsType) {
        this.bcfCredentialsType = bcfCredentialsType;
    }

    public String getBcfCredentialsNumber() {
        return bcfCredentialsNumber;
    }

    public void setBcfCredentialsNumber(String bcfCredentialsNumber) {
        this.bcfCredentialsNumber = bcfCredentialsNumber;
    }

    public String getBcfMobileNumber() {
        return bcfMobileNumber;
    }

    public void setBcfMobileNumber(String bcfMobileNumber) {
        this.bcfMobileNumber = bcfMobileNumber;
    }

    public String getBcfChannelCode() {
        return bcfChannelCode;
    }

    public void setBcfChannelCode(String bcfChannelCode) {
        this.bcfChannelCode = bcfChannelCode;
    }

    public String getBcfChannelName() {
        return bcfChannelName;
    }

    public void setBcfChannelName(String bcfChannelName) {
        this.bcfChannelName = bcfChannelName;
    }

    public Integer getBcfBankCode() {
        return bcfBankCode;
    }

    public void setBcfBankCode(Integer bcfBankCode) {
        this.bcfBankCode = bcfBankCode;
    }

    public String getBcfBankName() {
        return bcfBankName;
    }

    public void setBcfBankName(String bcfBankName) {
        this.bcfBankName = bcfBankName;
    }

    public String getBcfBizChannel() {
        return bcfBizChannel;
    }

    public void setBcfBizChannel(String bcfBizChannel) {
        this.bcfBizChannel = bcfBizChannel;
    }

    public Byte getBcfStatus() {
        return bcfStatus;
    }

    public void setBcfStatus(Byte bcfStatus) {
        this.bcfStatus = bcfStatus;
    }

    public String getBcfResponseCode() {
        return bcfResponseCode;
    }

    public void setBcfResponseCode(String bcfResponseCode) {
        this.bcfResponseCode = bcfResponseCode;
    }

    public String getBcfResponseDesc() {
        return bcfResponseDesc;
    }

    public String getBcfAdditionalCode() {
        return bcfAdditionalCode;
    }

    public void setBcfAdditionalCode(String bcfAdditionalCode) {
        this.bcfAdditionalCode = bcfAdditionalCode;
    }

    public void setBcfResponseDesc(String bcfResponseDesc) {
        this.bcfResponseDesc = bcfResponseDesc;
    }

    public String getBcfMark() {
        return bcfMark;
    }

    public void setBcfMark(String bcfMark) {
        this.bcfMark = bcfMark;
    }

    public Date getBcfModifyTime() {
        return bcfModifyTime;
    }

    public void setBcfModifyTime(Date bcfModifyTime) {
        this.bcfModifyTime = bcfModifyTime;
    }

    public Date getBcfCreateTime() {
        return bcfCreateTime;
    }

    public void setBcfCreateTime(Date bcfCreateTime) {
        this.bcfCreateTime = bcfCreateTime;
    }

    @Override
    public String toString() {
        return "BankContractFlow{" +
                "bfcId=" + bfcId +
                ", bcfBizSequenceCode='" + bcfBizSequenceCode + '\'' +
                ", bcfChannelSequenceCode='" + bcfChannelSequenceCode + '\'' +
                ", bcfBizType=" + bcfBizType +
                ", bcfCardNo='" + bcfCardNo + '\'' +
                ", bcfHolder='" + bcfHolder + '\'' +
                ", bcfCredentialsType='" + bcfCredentialsType + '\'' +
                ", bcfCredentialsNumber='" + bcfCredentialsNumber + '\'' +
                ", bcfMobileNumber='" + bcfMobileNumber + '\'' +
                ", bcfChannelCode='" + bcfChannelCode + '\'' +
                ", bcfChannelName='" + bcfChannelName + '\'' +
                ", bcfBankCode=" + bcfBankCode +
                ", bcfBankName='" + bcfBankName + '\'' +
                ", bcfBizChannel='" + bcfBizChannel + '\'' +
                ", bcfStatus=" + bcfStatus +
                ", bcfResponseCode='" + bcfResponseCode + '\'' +
                ", bcfResponseDesc='" + bcfResponseDesc + '\'' +
                ", bcfAdditionalCode='" + bcfAdditionalCode + '\'' +
                ", bcfMark='" + bcfMark + '\'' +
                ", bcfModifyTime=" + bcfModifyTime +
                ", bcfCreateTime=" + bcfCreateTime +
                '}';
    }
}
