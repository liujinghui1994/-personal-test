package com.umbrella.core.common.redis_manage.redisapi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

/**
 * @program: com.umbrella.core.metadata_manage.redisapi
 * @description:
 *
 * <p>集合类型（set）
 * <p>集合类型值具有唯一性，常用操作是向集合添加、删除、判断某个值是否存在，集合内部是使用值为空的散列表实现的。
 * <p>添加元素：SADD             语法：SADD key member [member ...] ，向一个集合添加一个或多个元素，因为集合的唯一性，所以添加相同值时会被忽略。
 * <p>　　　　　　　　　　　　　　　         返回成功添加元素的数量。
 * <p>删除元素：SREM             语法：SREM key member [member ...] 删除集合中一个或多个元素，返回成功删除的个数。
 * <p>获取全部元素：SMEMBERS     语法：SMEMBERS key ，返回集合全部元素
 * <p>值是否存在：SISMEMBER      语法：SISMEMBER key member ，如果存在返回1，不存在返回0
 * <p>差运算：SDIFF             语法：SDIFF key [key ...] ，例如：集合A和集合B，差集表示A-B，在A里有的元素B里没有，返回差集合；多个集合(A-B)-C
 * <p>交运算：SINTER            语法：SINTER key [key ...]，返回交集集合，每个集合都有的元素
 * <p>并运算：SUNION　　　　　　 语法：SUNION key [key ...]，返回并集集合，所有集合的元素
 * <p>集合元素个数：SCARD       语法：SCARD key ，返回集合元素个数
 * <p>集合运算后存储结果         语法：SDIFFSTROE destination key [key ...] ，差运算并存储到destination新集合中
 * <p>　　　　　　　　　　 　　　　　　　SINTERSTROE destination key [key ...]，交运算并存储到destination新集合中
 * <p>                                SUNIONSTROE destination key [key ...]，并运算并存储到destination新集合中
 * <p>随机获取元素：SRANDMEMGER 语法：SRANDMEMBER key [count]，根据count不同有不同结果，count大于元素总数时返回全部元素
 * <p>　　　　　　　　　　　　　　　　　　count>0 ，返回集合中count不重复的元素
 * <p>　　　　　　　　　　　　　　　　　　count<0，返回集合中count的绝对值个元素，但元素可能会重复
 * <p>弹出元素：SPOP            法：SPOP key [count] ，因为集合是无序的，所以spop会随机弹出一个元素
 * @author: liujinghui
 * @create: 2019-01-12 15:57
 **/
@Component
public class RedisSetAPI extends RedisBaseAPI {

    /**
     * <p>添加元素：SADD             语法：SADD key member [member ...] ，向一个集合添加一个或多个元素，因为集合的唯一性，所以添加相同值时会被忽略。
     * <p>　　　　　　　　　　　　　　　         返回成功添加元素的数量。
     * @param key
     * @param values
     * @return
     */
    public long add(String key,String ... values) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long result =  jedis.sadd(key,values);
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 删除元素：SREM  语法：SREM key member [member ...] 删除集合中一个或多个元素，返回成功删除的个数。
     * @param key
     * @param values
     * @return
     */
    public long del(String key,String ... values) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long result =  jedis.srem(key,values);
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 获取全部元素：SMEMBERS     语法：SMEMBERS key ，返回集合全部元素
     * @param key
     * @return
     */
    public Set<String> getKeyAllMembers(String key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            Set<String> result =  jedis.smembers(key);
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 判断值是否存在：SISMEMBER      语法：SISMEMBER key member ，如果存在返回1，不存在返回0
     * @param key
     * @param member
     * @return
     */
    public boolean isMemberExist(String key,String member) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            boolean result =  jedis.sismember(key,member);
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 差运算：SDIFF  语法：SDIFF key [key ...] ，例如：集合A和集合B，差集表示A-B，在A里有的元素B里没有，返回差集合；多个集合(A-B)-C
     * @param key 多个String类型的key 第一个key 跟后面若干个key进行比较
     * @return
     */
    public Set<String> getDifferentMember(String ... key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            Set<String> differentMenber =  jedis.sdiff(key);
            return differentMenber;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 集合运算后存储结果         语法：SDIFFSTROE destination key [key ...] ，差运算并存储到destination新集合中
     * @param destKey 有差异的新数据存储到新的key中。
     * @param key 第一个key跟后面若干个key进行比较
     * @return 存储的数据数量
     */
    public long storeDifferentMember(String destKey,String ... key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long storedDifferentMemberCount =  jedis.sdiffstore(destKey,key);
            return storedDifferentMemberCount;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 交运算：SINTER            语法：SINTER key [key ...]，返回交集集合，每个集合都有的元素
     * @param key 多个String类型的key 第一个key 跟后面若干个key进行比较
     * @return
     */
    public Set<String> getIntersectionMember(String ... key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            Set<String> intersectionMenber =  jedis.sinter(key);
            return intersectionMenber;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 集合运算后存储结果         语法：SINTERSTROE destination key [key ...]，交运算并存储到destination新集合中
     * @param destKey 有交集的新数据存储到新的key中
     * @param key 第一个key跟后面若干个key进行比较
     * @return 存储的数据数量
     */
    public long storeIntersectionMember(String destKey, String ... key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long storedIntersectionMemberCount =  jedis.sinterstore(destKey,key);
            return storedIntersectionMemberCount;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 并运算：SUNION　　　　　　 语法：SUNION key [key ...]，返回并集集合，所有集合的元素
     * @param key 多个String类型的key 第一个key 跟后面若干个key进行比较
     * @return
     */
    public Set<String> getUnionMember(String ... key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            Set<String> unionMenber =  jedis.sunion(key);
            return unionMenber;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 集合运算后存储结果    SUNIONSTROE destination key [key ...]，并运算并存储到destination新集合中
     * @param destKey 并集的新数据存储到新的destKey中
     * @param key 多个String类型的key 第一个key 跟后面若干个key进行比较
     * @return 存储的数据数量
     */
    public long storeUnionMember(String destKey, String key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long storedUnionMemberCount =  jedis.sunionstore(destKey,key);
            return storedUnionMemberCount;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 集合元素个数：SCARD  语法：SCARD key ，返回集合元素个数
     * @param key 待查询的key
     * @return
     */
    public long getkeyMembersCount(String key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long membersCount =  jedis.scard(key);
            return membersCount;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

}
