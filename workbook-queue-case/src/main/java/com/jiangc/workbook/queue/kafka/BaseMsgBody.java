package com.jiangc.workbook.queue.kafka;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

//@Data
public class BaseMsgBody {
    public String getMainEventNo() {
        return mainEventNo;
    }

    public void setMainEventNo(String mainEventNo) {
        this.mainEventNo = mainEventNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getResultState() {
        return resultState;
    }

    public void setResultState(String resultState) {
        this.resultState = resultState;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(String operateUserId) {
        this.operateUserId = operateUserId;
    }

    public String getOperateUserName() {
        return operateUserName;
    }

    public void setOperateUserName(String operateUserName) {
        this.operateUserName = operateUserName;
    }

    public String getOperateDepartId() {
        return operateDepartId;
    }

    public void setOperateDepartId(String operateDepartId) {
        this.operateDepartId = operateDepartId;
    }

    public String getOperateDepartName() {
        return operateDepartName;
    }

    public void setOperateDepartName(String operateDepartName) {
        this.operateDepartName = operateDepartName;
    }

    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }

    public ProcessDTO getProcessDTO() {
        return processDTO;
    }

    public void setProcessDTO(ProcessDTO processDTO) {
        this.processDTO = processDTO;
    }

    /**
     * 主事件编号
     */
    private String mainEventNo;

    /**
     * 工单ID
     */
    private String orderId;

    /**
     * 节点状态
     */
    private String resultState;

    /**
     * 意见
     */
    private String suggest;

    /**
     * 操作用户ID
     */
    private String operateUserId;

    /**
     * 操作用户名称
     */
    private String operateUserName;

    /**
     * 操作部门ID
     */
    private String operateDepartId;

    /**
     * 操作部门名称
     */
    private String operateDepartName;

    /**
     * 操作时间不能为空
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime operateTime;

    /**
     * 事件流水
     */
    private ProcessDTO processDTO;
}