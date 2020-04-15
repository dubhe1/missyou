package com.missyou.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.missyou.exception.http.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SuperGenericAndJson<T> implements AttributeConverter<T, String> {
    @Autowired
    private ObjectMapper mapper;


    @Override
    public String convertToDatabaseColumn(T t) {
        try {
            return mapper.writeValueAsString(t);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }

    @Override
    public T convertToEntityAttribute(String s) {
        try {
            if (s == null) {
                return null;
            }

            return mapper.readValue(s, new TypeReference<T>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerErrorException(9999);
        }
    }
}
