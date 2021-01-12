package com.jiangc.workbook.queue.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;

import java.util.Properties;

public class Producer {
    //static Logger log = Logger.getLogger(Producer.class);

    private static KafkaProducer<String,String> producer = null;

    /*
    初始化生产者
     */
    static {
        Properties configs = initConfig();
        producer = new KafkaProducer<String, String>(configs);
    }

    /*
    初始化配置
     */
    private static Properties initConfig(){
        Properties props = new Properties();
        props.put("bootstrap.servers", MQDict.MQ_ADDRESS_COLLECTION);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        return props;
    }


    public static void main(String[] args) throws InterruptedException {
        //消息实体
        ProducerRecord<String , String> record = null;
        //for (int i = 0; i < 100; i++) {
            //record = new ProducerRecord<String, String>(MQDict.PRODUCER_TOPIC, "value"+i);
        record = new ProducerRecord<String, String>(MQDict.PRODUCER_TOPIC, "value");

        EndProcessMsg endProcessMsg = new EndProcessMsg();
        endProcessMsg.setAssigneeGroup("NTKFQ");
        endProcessMsg.setDoAction("END");
        endProcessMsg.setStatus(1);
        endProcessMsg.setMainEventNo("TEST001");
        endProcessMsg.setOperateDepartId("NT");
        endProcessMsg.setOperateDepartName("南通");
        endProcessMsg.setOrderId("1");
        endProcessMsg.setResultState("10");
        endProcessMsg.setSuggest("请求办结");

//        ProducerBuilder.builder(MQDict.PRODUCER_TOPIC,endProcessMsg).addHeader();

            //发送消息
            producer.send(record, (recordMetadata, e) -> {
                if (null != e){
                    //log.info("send error" + e.getMessage());
                    System.out.println("send error" + e.getMessage());
                }else {
                    System.out.println(String.format("offset:%s,partition:%s",recordMetadata.offset(),recordMetadata.partition()));
                }
            });
        //}
        producer.close();
    }
}
