package com.jiangc.workbook.queue.kafka;


import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author yuwenbo1
 * email: yuwenbo10@jd.com
 * copyright: © 2020 智能城市icity.jd.com ALL Right Reserved
 * @version v1.0.0
 * <p>
 * Jackson 序列化
 * </p>
 * @since 2020/12/10 10:31
 */
public class JacksonHelper {

    static Logger log = LoggerFactory.getLogger(JacksonHelper.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final String DEFAULT_DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    private static final String DEFAULT_DATE_FORMATTER = "yyyy-MM-dd";

    private static final String DEFAULT_TIME_FORMATTER = "HH:mm:ss";

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator jg,
                                  SerializerProvider sp) throws IOException,
                    JsonProcessingException {
                jg.writeString("");
            }
        });
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                    throws IOException, JsonProcessingException {
                String value = jsonParser.getValueAsString();
                if (Strings.isNullOrEmpty(value)) {
                    return null;
                }
                return LocalDateTime.parse(jsonParser.getValueAsString(), DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMATTER));
            }
        });
        javaTimeModule.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                if (Objects.isNull(localDateTime)) {
                    jsonGenerator.writeString("");
                }
                jsonGenerator.writeString(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMATTER).format(localDateTime));
            }
        });
        javaTimeModule.addDeserializer(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                    throws IOException, JsonProcessingException {
                if(Strings.isNullOrEmpty(jsonParser.getValueAsString())){
                    return null;
                }
                return LocalDate.parse(jsonParser.getValueAsString(), DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMATTER));
            }
        });
        javaTimeModule.addSerializer(LocalDate.class, new JsonSerializer<LocalDate>() {
            @Override
            public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                if (Objects.isNull(localDate)) {
                    jsonGenerator.writeString("");
                }else {
                    jsonGenerator.writeString(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMATTER).format(localDate));
                }
            }
        });
        javaTimeModule.addDeserializer(LocalTime.class, new JsonDeserializer<LocalTime>() {
            @Override
            public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
                    throws IOException, JsonProcessingException {
                if(Strings.isNullOrEmpty(jsonParser.getValueAsString())){
                    return null;
                }
                return LocalTime.parse(jsonParser.getValueAsString(), DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMATTER));
            }
        });
        javaTimeModule.addSerializer(LocalTime.class, new JsonSerializer<LocalTime>() {
            @Override
            public void serialize(LocalTime localTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                if(Objects.isNull(localTime)){
                    jsonGenerator.writeString("");
                }
                jsonGenerator.writeString(DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMATTER).format(localTime));
            }
        });
        objectMapper.registerModules(javaTimeModule);
    }

    public static String obj2Json(Object obj) throws IOException {
        return objectMapper.writeValueAsString(obj);
    }

    public static <T> T json2Obj(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json, clazz);
    }

    /**
     * 可以把Json字符串转换成List
     */
    public static <T> T parseObject(String json, TypeReference<T> typeReference) {
        try {
            return (T) objectMapper.readValue(json, typeReference);
        } catch (JsonParseException e) {
            log.error("parseObject(String, TypeReference<T>) JsonParseException", e);
        } catch (JsonMappingException e) {
            log.error("parseObject(String, TypeReference<T>) JsonMappingException", e);
        } catch (IOException e) {
            log.error("parseObject(String, TypeReference<T>)", e);
        }
        return null;
    }


    public static JsonNode readRootNode(String json) {
        return readAnyNode(json, null);
    }

    /**
     * 根据json key 获取任意层级的jsonNode
     */
    public static JsonNode readAnyNode(String json, String fieldName) {
        try {
            JsonNode rootNode = objectMapper.readTree(json);
            if ("".equals(fieldName)) {
                return rootNode;
            }
            return rootNode.findValue(fieldName);
        } catch (IOException e) {
            log.error("readNode(String json,String fieldName)", e);
        }
        return null;
    }


    //创建jsonNode
    public static ObjectNode createObjectNode() {
        return objectMapper.createObjectNode();
    }

    /**
     * 格式化输出json
     */
    public static <T> String console(T t) {
        String json = "";
        try {
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
        } catch (JsonGenerationException e) {
            log.error("console(T t) JsonGenerationException", e);
        } catch (JsonMappingException e) {
            log.error("console(T t) JsonMappingException", e);
        } catch (IOException e) {
            log.error("console(T t)", e);
        }
        return json;
    }
}
