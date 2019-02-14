package com.umbrella.core.common.redis_manage.redisapi;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @program: com.umbrella.core.metadata_manage.redisapi
 * @description:
 * <p>
 * <p>有序集合类型
 * <p>添加集合元素：ZADD          语法：ZADD key [NX|XX] [CH] [INCR] score member [score member ...]，不存在添加，存在更新。
 * <p>获取元素分数：ZSCORE        语法：ZSCORE key member ，返回元素成员的score 分数
 * <p>元素小到大：ZRANGE          语法：ZRANGE key start top [WITHSCORES] ，参考LRANGE ，加上withscores 返回带元素，即元素，分数
 *                                                   当分数一样时，按元素排序
 * <p>元素大到小：ZREVRANGE       语法：ZREVRANGE key start [WITHSCORES] ，与zrange区别在于zrevrange是从大到小排序
 * <p>指定分数范围元素：ZRANGEBYSCORE   语法：ZRANGEBYSCORE key min max [WITHSCORE] [LIMIT offest count]
 *  　　　　　　　　　　　　　　　返回从小到大的在min和max之间的元素，( 符号表示不包含，例如：80-100，(80 100，
 * 　　　　　　　　　　　　　　    withscore返回带分数
 * 　　　　　　　　　　　　　　    limit offest count 向左偏移offest个元素，并获取前count个元素
 * <p>指定分数范围元素：ZREVRANGESCORE   语法：ZREVRANGEBYSCORE key max  min [WITHSCORE] [LIMIT offest count]
 * 　　　　　　　　　　　　　　　 与zrangebyscore类似，只不过该命令是从大到小排序的。
 * <p>增加分数：ZINCRBY     语法：ZINCRBY key increment member ，注意是增加分数，返回增加后的分数；如果成员不存在，则添加一个为0的成员。
 * @author: liujinghui
 * @create: 2019-01-12 15:57
 **/
@Component
public class RedisSSetAPI extends RedisBaseAPI {


    /**
     * 添加集合元素：ZADD          语法：ZADD key [NX|XX] [CH] [INCR] score member [score member ...]，不存在添加，存在更新。
     * @param key 集合key
     * @param score 分数：所谓的分数就是一个排名的参考数据
     * @param member 成员
     * @return 返回添加的元素个数
     */
    public long add(String key,double score, String member) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long addNumber =  jedis.zadd(key,score,member);
            return addNumber;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 根据key获取该key下所有的members数量
     * edis Zcard 命令基本语法如下： ZCARD KEY_NAME
     * @param key
     * @return
     */
    public long getMembersCountByKey(String key) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long memberCount =  jedis.zcard(key);
            return memberCount;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * 根据key获取start到end范围内的member数量
     * @param key 待查询的key
     * @param start 起始范围
     * @param end 结束范围
     * @return 返回该score范围内的members数量
     */
    public long getMembersCountByScoreRange(String key,double start,double end) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long memberCount =  jedis.zcount(key,start,end);
            return memberCount;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 删除元素：ZREM  语法：ZREM key member [member ...] 删除集合中一个或多个元素，返回成功删除的个数。
     * @param key
     * @param values
     * @return 删除个数
     */
    public long del(String key,String ... values) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            long result =  jedis.zrem(key,values);
            return result;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 元素小到大：ZRANGE   语法：ZRANGE key start top [WITHSCORES] ，参考LRANGE ，加上withscores 返回带元素，即元素，分数
     * @param key 带查询的key
     * @param start 待查询的上界，注意不会包含上界
     * @param end 待查询的下界，注意会包含下界的值
     * @return 返回score
     */
    public Set<String> getMembersByScoreAsc(String key,long start, long end) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            Set<String> members =  jedis.zrange(key,start,end);
            return members;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 元素大到小：ZREVRANGE       语法：ZREVRANGE key start [WITHSCORES] ，与zrange区别在于zrevrange是从大到小排序
     * @param key 带查询的key
     * @param start 待查询的上界，注意不会包含上界
     * @param end 待查询的下界，注意会包含下界的值
     * @return 返回score
     */
    public Set<String> getMembersByScoreDesc(String key,long start, long end) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            Set<String> members =  jedis.zrevrange(key,start,end);
            return members;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }


    /**
     * 获取元素分数：ZSCORE        语法：ZSCORE key member ，返回元素成员的score 分数
     * @param key 待查询的key
     * @param member
     * @return
     */
    public double getScoreByKeyAndMember(String key,String member) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            double zscore =  jedis.zscore(key,member);
            return zscore;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 增加分数：ZINCRBY     语法：ZINCRBY key increment member ，注意是增加分数，返回增加后的分数；如果成员不存在，则添加一个为0的成员。
     * @param key 待增加的key
     * @param score 增加的score数，例如原来score是1  这里的参数填6 那么现在member的score是7
     * @param member 待增加的member
     * @return 返回增加后的score
     */
    public double increaseScoreByKeyAndMember(String key,double score,String member) {
        Jedis jedis = null;
        try {
            jedis =  jedisPool.getResource();
            double zscore =  jedis.zincrby(key,score,member);
            return zscore;
        }finally {
            if(jedis != null) {
                jedis.close();
            }
        }
    }

}
