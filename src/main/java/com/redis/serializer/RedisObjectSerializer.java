package com.redis.serializer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * Created by Movie on 2017/7/7.
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

    private Converter<Object, byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    static final byte[] EMPTY_ARdRAY = new byte[0];


    @Override
    public byte[] serialize(Object o) throws SerializationException {
        return o == null ? EMPTY_ARdRAY : serializer.convert(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return isEmpty(bytes) ? null : deserializer.convert(bytes);
    }

    private boolean isEmpty(byte [] bytes) {
        return bytes == null || bytes.length == 0;
    }
}
