package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author:Lazy1ron
 * @date:2019/10/20 13:08
 */
public class MyJedisPool {

    private static JedisPoolConfig config = new JedisPoolConfig();
    private static JedisPool jedisPool;

    static {
        config.setMaxTotal(10);
        jedisPool = new JedisPool(config, "localhost");
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void destroy() {
        jedisPool.destroy();
    }
}
