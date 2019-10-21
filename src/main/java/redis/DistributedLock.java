package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;
import java.util.UUID;

/**
 * @author:Lazy1ron
 * @date:2019/10/20 13:24
 */
public class DistributedLock {

    private static Jedis client;
    //private static final String SET_IF_NOT_EXIST = "NX";
    //private static final String EXPIRED_TIME = "EX";
    private static final String LOCK_SUCCESS = "OK";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * @Author Lazy1ron
     * @Description: //获取分布式锁
     * @Date 13:45 2019/10/20
     * @Param [Redis客户端，分布式锁，请求标识，过期时时间]
     * @Param [jedis, lockKey, requestId, expireTime]
     * @return void
     **/
    private static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expiredTime) {
        SetParams params = new SetParams();
        // Lock过期时间
        params.ex(expiredTime);
        // 如果不存在则创建
        params.nx();
        String result = jedis.set(lockKey, requestId, params);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    private static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {
        String scripts = "if redis.call('get', KEYS[1]) == ARGV[1] then redis.call('del', KEYS[1]) else return 0 end";
        // eval表达式具有原子性
        Object result = jedis.eval(scripts, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (result != null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        String lockKey = "lazy1ron";
        String requestId = UUID.randomUUID().toString();
        try {
            boolean flag = false;
            client = MyJedisPool.getJedis();
            System.out.println(client.ping());
            // 尝试加锁
            if (flag == tryGetDistributedLock(client, lockKey, requestId, 60)) {
                System.out.println("加锁失败");
            } else {
                System.out.println("加锁成功");
            }

            Thread.sleep(10);

            // 尝试解锁
            if (flag == releaseDistributedLock(client, lockKey, requestId)) {
                System.out.println("解锁失败");
            } else {
                System.out.println("解锁成功");
            }
        } finally {
            if (client != null) {
                client.close();
                MyJedisPool.destroy();
                System.out.println("client关闭");
            }
        }
    }
}
