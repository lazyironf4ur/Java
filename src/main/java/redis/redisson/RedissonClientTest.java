package redis.redisson;

import org.redisson.api.RedissonClient;

/**
 * @author:Lazy1ron
 * @date:2021/4/27 14:47
 */
public class RedissonClientTest {

    private static final RedissonProperties rp = new RedissonProperties();

    public static void main(String[] args) {
        rp.setServerAddress("rediss://127.0.0.1");
        rp.setPort("6379");
        rp.setPassword(null);

        RedissonClient client = new RedissonConfig().redissonClient(rp);

        System.out.println(client.getId());
    }

}
