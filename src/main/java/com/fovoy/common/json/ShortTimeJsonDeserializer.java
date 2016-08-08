package com.fovoy.common.json;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

/**
 * Created by zxz.zhang on 15/11/14.
 */
public class ShortTimeJsonDeserializer extends JsonDeserializer<ShortTime> {
    public ShortTimeJsonDeserializer() {
    }

    public ShortTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String time = jsonParser.getText();
        return time != null && !time.isEmpty()?new ShortTime(time):null;
    }
}
