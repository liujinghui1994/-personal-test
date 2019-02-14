package com.umbrella.core.common.redis_manage.redisapi;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @program: com.umbrella.core.metadata_manage.redisapi
 * @description:
 *
 *<p>字符串类型string
 *<p>字符串类型是Redis的最基本类型，它可以存储任何形式的字符串。其它的四种类型都是字符串类型的不同形式。
 *<p>最基本的命令：GET、SET         语法：GET key，SET key value   value如果有空格需要双引号以示区分
 *<p>整数递增：INCR                 语法：INCR key    默认值为0，所以首先执行命令得到 1 ，不是整型提示错误
 *<p>增加指定的整数：INCRBY         语法：INCRBY key increment
 *<p>整数递减：DECR                 语法：DECR key   默认值为0，所以首先执行命令得到 -1，不是整型提示错误
 *<p>减少指定的整数：DECRBY         语法：DECRBY key increment
 *<p>增加指定浮点数：INCRBYFLOAT    语法：INCRBYFLOAT key increment  与INCR命令类似，只不过可以递增一个双精度浮点数
 *<p>向尾部追加值：APPEND           语法：APPEND key value   redis客户端并不是输出追加后的字符串，而是输出字符串总长度
 *<p>获取字符串长度：STRLEN         语法：STRLEN key  如果键不存在返回0，注意如果有中文时，一个中文长度是3，redis是使用UTF-8编码中文的
 *<p>获取多个键值：MGET             语法：MGET key [key ...]  例如：MGET key1 key2
 *<p>设置多个键值：MSET             语法：MSET key value [key value ...]  例如：MSET key1 1 key2 "hello redis"
 *<p>二进制指定位置值：GETBIT        语法：GETBIT key offset   例如：GETBIT key1 2 ，key1为hello 返回 1，返回的值只有0或1，
 *<p>             　　　　　　　　　　　　　　　　　　 当key不存在或超出实际长度时为0
 *<p>设置二进制位置值：SETBIT       语法：SETBIT key offset value ，返回该位置的旧值
 *<p>二进制是1的个数：BITCOUNT      语法：BITCOUNT key [start end] ，start 、end为开始和结束字节
 *<p>位运算：BITOP                 语法：BITOP operation destkey key [key ...]  ，operation支持AND、OR、XOR、NOT
 *<p>偏移：BITPOS                  语法：BITPOS key bit [start] [end]
 *
 * @author: liujinghui
 * @create: 2019-01-12 15:57
 **/
@Component
public class RedisStringAPI extends RedisBaseAPI {

    /**
     * get单个redis数据
     * @param key
     * @return T
     */
    public <T> T get(String key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            T t = (T) jedis.get(key);
            return t;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * get单个redis数据
     * @param key
     * @return T
     */
    public byte[] get(byte[] key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            byte[] bytes = jedis.get(key);
            return bytes;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 存redis单个值
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(String key,  T value) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            if(key == null || key.length() <= 0) {
                return false;
            }
            jedis.set(key, value.toString());
            return true;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 存redis单个值
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key,  byte[] value) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            if(key == null || key.length() <= 0) {
                return false;
            }
            jedis.set(key.getBytes(), value);
            return true;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 删除
     * */
    public boolean delete(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            long ret = jedis.del(key);
            return ret > 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public boolean increment(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            long ret = jedis.incr(key);
            return ret > 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    public boolean incrementByLong(String key,long number){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            long ret = jedis.incrBy(key,number);
            return ret > 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public boolean decrement(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            long ret = jedis.decr(key);
            return ret > 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
    public boolean decrementByLong(String key,long number){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            long ret = jedis.decrBy(key,number);
            return ret > 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public boolean incrementByFloat(String key,double number){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            double ret = jedis.incrByFloat(key,number);
            return ret > 0;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public long append(String key,String content) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long result =  jedis.append(key,content);
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * <p>获取字符串长度：STRLEN         语法：STRLEN key  如果键不存在返回0，注意如果有中文时，一个中文长度是3，redis是使用UTF-8编码中文的
     * @param key
     * @return
     */
    public long strline(String key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long result =  jedis.strlen(key);
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * <p>获取多个键值：MGET             语法：MGET key [key ...]  例如：MGET key1 key2
     * @param key
     * @return
     */
    public long mGet(String key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long result =  jedis.strlen(key);
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * <p>设置多个键值：MSET        语法：MSET key value [key value ...]  例如：MSET key1 1 key2 "hello redis"
     * <p>jedis中传入参数实例："name","ljh","age","18"
     * <p>这样 key就是name age  value 就是ljh 18
     * <p>二进制指定位置值：GETBIT   语法：GETBIT key offset   例如：GETBIT key1 2 ，key1为hello 返回 1，返回的值只有0或1，
     * <p>当key不存在或超出实际长度时为0
     * @param keyvalues
     * @return
     */
    public boolean mSet(String ... keyvalues) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            String result =  jedis.mset(keyvalues);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            if(jedis != null) {
                jedis.close();
            }
        }
    }


}
