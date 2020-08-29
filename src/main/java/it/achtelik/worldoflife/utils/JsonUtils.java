package it.achtelik.worldoflife.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public String toJson(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public <T> T toObject(String content, Class<T> valueType) {
        try {
            return OBJECT_MAPPER.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
