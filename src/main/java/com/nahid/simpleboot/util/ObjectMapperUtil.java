package com.nahid.simpleboot.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {
    public static Object mapObject(Object ob, Object convertTo) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return  mapper.convertValue(ob, convertTo.getClass());
    }
}
