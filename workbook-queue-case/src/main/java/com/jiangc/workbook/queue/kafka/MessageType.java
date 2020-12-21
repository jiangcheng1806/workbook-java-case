package com.jiangc.workbook.queue.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;

import java.util.Objects;
import java.util.stream.Stream;

public enum MessageType {
    //-----------------------------事件----------------------------//
    /**
     * 事件创建
     */
    EventCreated,
    /**
     * 主事件创建
     */
    MainEventCreated,
    /**
     * 辨重异常
     */
    DiffRepeatException,
    //-----------------------------内部工单----------------------------//
    /**
     * 方案创建
     */
    PlanCreated,
    /**
     * 方案修改
     */
    PlanUpdated,
    /**
     * 审核消息
     */
    AuditMessage,

    /**
     * 处置给工单消息
     */
    OrderMessage,

    //-----------------------------动态工作流----------------------------//
    /**
     * 工单创建
     */
    OrderCreated,
    /**
     * 工单取消
     */
    OrderCanceled,
    /**
     * 工单终止
     */
    OrderStop,
    /**
     * 工单驳回
     */
    OrderRejected,
    /**
     * 上游状态改变
     */
    UpStateChanged,
    /**
     * 上游状态改变
     */
    DownStateChanged,

    //-----------------------------处置----------------------------//
    /**
     * 流程消息
     */
    ProcessMessage,
    /**
     * 处置消息
     */
    DisposalMessage,

    /**
     * 工单签收
     */
    OrderAccept,
    /**
     * 工单反馈
     */
    OrderFeedback,
    /**
     * 工单退回
     */
    OrderGoBack,
    /**
     * 最终办结
     */
    OrderFinish
//    /**
//     * 派单消息
//     */
//    Dispatch,
//    /**
//     * 分拨消息
//     */
//    Distribute,
//    /**
//     * 签收消息
//     */
//    Accept,
//    /**
//     * 同步消息
//     */
//    Sync,
//    /**
//     * 反馈处置消息
//     */
//    Feedback,
//    /**
//     * 锁定状态
//     */
//    Lock,
    ;

    public static boolean isType(ConsumerRecord<String, String> consumerRecord, MessageType messageType) {
        MessageType type = getType(consumerRecord);
        return type.equals(messageType);
    }

    public static MessageType getType(ConsumerRecord<String, String> consumerRecord) {
        Headers headers = consumerRecord.headers();
        Iterable<Header> msgType = headers.headers("msgType");
        //Assert.notNull(msgType, "未设置消息类型");
        for (Header header : msgType) {
            String s = new String(header.value());
            MessageType messageType =
                    Stream.of(MessageType.values())
                            .filter(a -> a.toString().equals(s))
                            .findAny()
                            .orElse(null);
            if (Objects.nonNull(messageType)) {
                return messageType;
            }
        }
        throw new IllegalArgumentException("未找到对应的消息类型[" + msgType + "]");
    }

}
