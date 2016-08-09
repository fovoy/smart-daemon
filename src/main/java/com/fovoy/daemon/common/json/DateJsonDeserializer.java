package com.fovoy.daemon.common.json;

import org.apache.commons.lang3.time.DateUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by zxz.zhang on 15/11/14.
 */

public class DateJsonDeserializer extends JsonDeserializer<Date> {
    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public DateJsonDeserializer() {
    }

    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String date = jsonParser.getText();
        if(date != null && !date.isEmpty()) {
            try {
                return DateUtils.parseDate(date, new String[]{"yyyy-MM-dd HH:mm:ss"});
            } catch (ParseException var5) {
                throw new JsonParseException("cannot parse date string: " + date, jsonParser.getCurrentLocation(), var5);
            }
        } else {
            return null;
        }
    }
}
