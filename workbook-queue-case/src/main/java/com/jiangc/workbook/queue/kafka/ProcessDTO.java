package com.jiangc.workbook.queue.kafka;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

//@Data
public class ProcessDTO {
    /**
     * 主事件编号
     */
    private String mainEventNo;
    /**
     * 处置意见
     */
    private String suggest;
    /**
     * 状态
     */
    private String action;
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

    public String getMainEventNo() {
        return mainEventNo;
    }

    public void setMainEventNo(String mainEventNo) {
        this.mainEventNo = mainEventNo;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
}
