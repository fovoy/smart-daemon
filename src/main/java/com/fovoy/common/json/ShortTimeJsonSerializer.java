package com.fovoy.common.json;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

/**
 * Created by zxz.zhang on 15/11/14.
 */
public class ShortTimeJsonSerializer extends JsonSerializer<ShortTime> {
    public ShortTimeJsonSerializer() {
    }

    public void serialize(ShortTime shortTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeString(shortTime != null?shortTime.toString():"null");
    }
}
