package com.umbrella.core.common.redis_manage.redisbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {
	
	@Autowired
	JedisPool jedisPool;

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
