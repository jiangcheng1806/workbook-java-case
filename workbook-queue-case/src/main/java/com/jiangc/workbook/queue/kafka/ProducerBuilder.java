package com.jiangc.workbook.queue.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ProducerBuilder {

    private static final String TYPE_STR = "msgType";

    public static final String SENDER = "sender";

    private String topic;

    private Integer partition;

    private final ArrayList<Header> headers = new ArrayList<>();

    private Object body;

    private Long timestamp = System.currentTimeMillis();

    private MessageType type;

    public static String serviceName;


    public ProducerBuilder() {
    }

    private ProducerBuilder(String topic, Object body) {
        this.topic = topic;
        this.body = body;
    }

    public static ProducerBuilder builder(String topic, Object body) {
        return new ProducerBuilder(topic, body);
    }

    public ProducerBuilder addHeader(String key, String value) {
        addHeaderCore(key, value.getBytes());
        return this;
    }

    public ProducerBuilder addHeader(String key, byte[] values) {
        addHeaderCore(key, values);
        return this;
    }

    private void addHeaderCore(String key, byte[] val) {
        RecordHeader header = new RecordHeader(key, val);
        this.headers.add(header);
    }

    public ProducerBuilder type(MessageType type) {
        this.type = type;
        return this;
    }

    public ProducerBuilder partition(Integer partition) {
        this.partition = partition;
        return this;
    }

    public ProducerBuilder timestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public ProducerRecord<String, Object> build() {
        // 设置消息类型
        addHeaderCore(TYPE_STR, type.toString().getBytes());
        addHeaderCore(SENDER, serviceName.getBytes(StandardCharsets.UTF_8));
        return new ProducerRecord<>(this.topic, partition, timestamp, null, body, this.headers);
    }
}