package com.fovoy.daemon.common.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author rongqian.xu created on 11/13/13 11:56 AM
 * @version $Id$
 */
public class DateJsonDeserializer extends JsonDeserializer<Date> {
    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException,
            JsonProcessingException {
        String date = jsonParser.getText();
        if (date != null && !date.isEmpty()) {
            try {
                return DateUtils.parseDate(date, DATE_PATTERN);
            } catch (ParseException e) {
                throw new JsonParseException("cannot parse date string: " + date, jsonParser.getCurrentLocation(), e);
            }
        }
        return null;
    }
}