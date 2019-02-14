package com.umbrella.core.common.common_util;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * @program: com.umbrella.core.common.common_util
 * @description:
 * @author: liujinghui
 * @create: 2018-12-08 15:32
 **/
public class ProtostuffUtil {

    /**
     * 序列化
     * @param t
     * @param <T>
     * @return
     */
    public static <T> byte[] serializer(T t){
        Schema schema = RuntimeSchema.getSchema(t.getClass());
        return ProtostuffIOUtil.toByteArray(t,schema,
                LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

    }

    /**
     * 反序列化
     * @param bytes
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T deserializer(byte []bytes,Class<T> c) {
        T t = null;
        try {
            t = c.newInstance();
            Schema schema = RuntimeSchema.getSchema(t.getClass());
            ProtostuffIOUtil.mergeFrom(bytes,t,schema);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

}
