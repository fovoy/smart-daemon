package com.fovoy.daemon.common.json;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;

/**
 * Created by zxz.zhang on 15/11/14.
 */
public class ShortDateJsonDeserializer extends JsonDeserializer<ShortDate> {
    public ShortDateJsonDeserializer() {
    }

    public ShortDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String time = jsonParser.getText();
        return time != null && !time.isEmpty()?new ShortDate(time):null;
    }
}
