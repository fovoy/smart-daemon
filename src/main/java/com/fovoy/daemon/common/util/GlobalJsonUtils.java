package com.fovoy.daemon.common.util;

import com.fovoy.daemon.common.json.*;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

import java.io.IOException;
import java.util.Date;

/**
 * Created by zxz.zhang on 16/8/8.
 */
public class GlobalJsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public GlobalJsonUtils() {
    }

    public static ObjectMapper getObjectMapperInstance() {
        return objectMapper;
    }

    public static String toJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (IOException var2) {
            throw new RuntimeException(var2);
        }
    }

    public static <T> T toBean(String json, Class<T> cls) {
        try {
            return objectMapper.readValue(json, cls);
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.CANONICALIZE_FIELD_NAMES, true);
        objectMapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        SimpleModule module = new SimpleModule("DateTimeModule", Version.unknownVersion());
        module.addDeserializer(ShortTime.class, new ShortTimeJsonDeserializer());
        module.addSerializer(ShortTime.class, new ShortTimeJsonSerializer());
        module.addDeserializer(ShortDate.class, new ShortDateJsonDeserializer());
        module.addSerializer(ShortDate.class, new ShortDateJsonSerializer());
        objectMapper.registerModule(module);
    }
}
