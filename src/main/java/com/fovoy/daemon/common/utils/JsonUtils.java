package com.fovoy.daemon.common.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fovoy.daemon.common.json.DateJsonDeserializer;
import com.fovoy.daemon.common.json.DateJsonSerializer;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * json 工具
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        SimpleModule module = new SimpleModule("DateTimeModule", Version.unknownVersion());
        module.addSerializer(Date.class, new DateJsonSerializer());
        module.addDeserializer(Date.class, new DateJsonDeserializer());
        objectMapper.registerModule(module);
    }

    public static ObjectMapper getObjectMapperInstance() {
        return objectMapper;
    }

    public static String toJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseJson(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException("Deserialize from JSON failed.", e);
        }
    }

    /**
     * 泛型化反序列化 List
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> List<T> parseJsonList(String json, Class<T> type) {
        if (StringUtils.isBlank(json)) {
            return Lists.newArrayList();
        }

        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, type);
        try {
            return objectMapper.readValue(json, collectionType);
        } catch (IOException e) {
            throw new RuntimeException("Deserialize from JSON failed.", e);
        }
    }
}
