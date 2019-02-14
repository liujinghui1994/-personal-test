package com.umbrella.core.common.redis_manage.redisapi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: com.umbrella.core.metadata_manage.redisapi
 * @description:
 *
 * <p>列表类型（list）
 *
 * <p>内部使用双向链表实现，所以获取越接近两端的元素速度越快，但通过索引访问时会比较慢
 *
 * <p>添加左边元素：LPUSH            语法：LPUSH key value [value ...]  ，返回添加后的列表元素的总个数
 *
 * <p>添加右边元素：RPUSH            语法：RPUSH key value [value ...]  ，返回添加后的列表元素的总个数
 *
 * <p>移除左边第一个元素：LPOP        语法：LPOP key  ，返回被移除的元素值
 *
 * <p>移除右边第一个元素：RPOP        语法：RPOP key ，返回被移除的元素值
 *
 * <p>列表元素个数：LLEN             语法：LLEN key， 不存在时返回0，redis是直接读取现成的值，并不是统计个数
 *
 * <p>获取列表片段：LRANGE           语法：LRANGE key start stop，如果start比stop靠后时返回空列表，0 -1 返回整个列表
 *
 *                                                     正数时：start 开始索引值，stop结束索引值（索引从0开始）
 *
 *                                                     负数时：例如 lrange num -2 -1，-2表示最右边第二个，-1表示最右边第一个，
 *
 * <p>删除指定值：LREM                 语法：LREM key count value，返回被删除的个数
 *
 *                                                    count>0，从左边开始删除前count个值为value的元素
 *
 *                                                    count<0，从右边开始删除前|count|个值为value的元素
 *
 *                                                    count=0，删除所有值为value的元素
 *
 * <p>索引元素值：LINDEX               语法：LINDEX key index ，返回索引的元素值，-1表示从最右边的第一位
 *
 * <p>设置元素值：LSET                 语法：LSET key index value
 *
 * <p>保留列表片段：LTRIM              语法：LTRIM key start stop，start、top 参考lrange命令
 *
 * <p>一个列表转移另一个列表：RPOPLPUSH   语法：RPOPLPUSH source desctination ，从source列表转移到desctination列表，
 *                                         该命令分两步看，首先source列表RPOP右移除，再desctination列表LPUSH
 * @author: liujinghui
 * @create: 2019-01-12 15:57
 **/
@Component
public class RedisListAPI extends RedisBaseAPI {
    public Object get(String key) {
        return null;
    }

    public Object set(String key, Object o) {
        return null;
    }

    public Object mGet(String... key) {
        return null;
    }

    public Object mSet(Map map) {
        return null;
    }
}
