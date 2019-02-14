package com.umbrella.core.common.redis_manage.redisapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @program: com.umbrella.core.metadata_manage
 * @description:
 * @author: liujinghui
 * @create: 2019-01-12 15:51
 **/
@Component
public class RedisBaseAPI<T> {

    @Autowired
    protected JedisPool jedisPool;

    public boolean testConnect(){
        return "pong".equals(jedisPool.getResource().ping());
    }

    /**
     *
     * 判断数据是否存在
     * @param key
     * @return
     */
    public boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            boolean ret = jedis.exists(key);
            return ret;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 更新redis失效日期
     * @param key
     * @param second
     * @param <T>
     * @return
     */
    public <T>long expire(String key,int second) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            long ret = jedis.expire(key,second);
            return ret;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


}
