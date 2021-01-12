package com.jiangc.workbook.queue.kafka;

import lombok.Data;

//@Data
public class EndProcessMsg extends BaseMsgBody {
    public String getDoAction() {
        return doAction;
    }

    public void setDoAction(String doAction) {
        this.doAction = doAction;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAssigneeGroup() {
        return assigneeGroup;
    }

    public void setAssigneeGroup(String assigneeGroup) {
        this.assigneeGroup = assigneeGroup;
    }

    private String doAction;
    private Integer status;
    //  办结待审批状态是多节点请求不需要传组织机构
    private String assigneeGroup;
}
