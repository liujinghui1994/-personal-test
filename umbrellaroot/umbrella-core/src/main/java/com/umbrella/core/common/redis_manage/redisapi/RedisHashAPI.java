package com.umbrella.core.common.redis_manage.redisapi;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

/**
 * @program: com.umbrella.core.metadata_manage.redisapi
 * @description:
 *
 * <p>散列类型hash
 * <p>设置单个：HSET              语法：HSET key field value，不存在时返回1，存在时返回0，没有更新和插入之分
 * <p>设置多个：HMSET             语法：HMSET key field value [field value ...]
 * <p>读取单个：HGET              语法：HGET key field，不存在是返回nil
 * <p>读取多个：HMGET             语法：HMGET key field [field ...]
 * <p>读取全部：HGETALL           语法：HGETALL key，返回时字段和字段值的列表
 * <p>判断字段是否存在：HEXISTS    语法：HEXISTS key field，存在返回1 ，不存在返回0
 * <p>字段不存在时赋值：HSETNX     语法：HSETNX key field value，与hset命令不同，hsetnx是键不存在时设置值
 * <p>增加数字：HINCRBY           语法：HINCRBY key field increment ，返回增加后的数，不是整数时会提示错误
 * <p>删除字段：HDEL              语法：HDEL key field [field ...] ，返回被删除字段的个数
 * <p>只获取字段名：HKEYS         语法：HKEYS key ，返回键的所有字段名
 * <p>只获取字段值：HVALS         语法：HVALS key  ，返回键的所有字段值
 * <p>字段数量：HLEN              语法：HLEN key ，返回字段总数
 * @author: liujinghui
 * @create: 2019-01-12 15:57
 **/
@Component
public class RedisHashAPI extends RedisBaseAPI {

    /**
     * <p>添加一条记录 如果map_key存在 则更新value
     * <p>hset 如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。
     * <p>如果字段已经存在于哈希表中，旧值将被覆盖
     * <p>设置单个：HSET              语法：HSET key field value，不存在时返回1，存在时返回0，没有更新和插入之分
     * @param key
     * @param field
     * @param value
     * @return
     */
    public boolean set(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long returnStatus  =  jedis.hset(key, field, value) ;
            return returnStatus>0;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 批量添加记录
     * hmset 同时将多个 field-value (域-值)对设置到哈希表 key 中。
     * 此命令会覆盖哈希表中已存在的域。
     * 如果 key 不存在，一个空哈希表被创建并执行 HMSET 操作。
     * 设置多个：HMSET             语法：HMSET key field value [field value ...]
     * @param key
     * @param map
     * @return
     */
    public  String setByMap(String key, Map<String, String> map) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            String result  =  jedis.hmset(key, map) ;
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }



    /**
     * 删除hash中 field对应的值
     * hdel 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略
     * 删除字段：HDEL              语法：HDEL key field [field ...] ，返回被删除字段的个数
     * @param key
     * @param field
     * @return
     */
    public  long delete(String key, String... field) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long returnStatus  =  jedis.hdel(key, field) ;
            return returnStatus;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取hash中 指定的field的值
     * hmget 返回哈希表 key 中，一个或多个给定域的值。
     * 如果给定的域不存在于哈希表，那么返回一个 nil 值。
     * 不存在的 key 被当作一个空哈希表来处理，所以对一个不存在的 key 进行 HMGET 操作将返回一个只带有 nil 值的表。
     *
     * @param key
     * @param field
     * @return
     */
    public List<String> getByKeyAndFields(String key, String... field) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            List<String> result  =  jedis.hmget(key, field) ;
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取hash中 所有的field value
     *
     * @param key
     * @return 在返回值里，紧跟每个字段名(field name)之后是字段的值(value)，所以返回值的长度是哈希表大小的两倍。
     */
    public  Map<String, String> getAllByKey(String key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            Map<String, String> result   =  jedis.hgetAll(key) ;
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 判断hash中 指定的field是否存在
     *
     * @param key
     * @param field
     * @return 如果哈希不包含字段或key不存在 返回0，如果哈希包含字段 返回1
     */
    public  boolean isExist(String key, String field) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            boolean result  =  jedis.hexists(key, field) ;
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取hash 的size
     * hlen 获取哈希表中字段的数量
     * @param key
     * @return
     */
    public  long getFieldSize(String key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long fieldSize =  jedis.hlen(key) ;
            return fieldSize;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }
}











