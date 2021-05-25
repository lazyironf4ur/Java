package redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;




public class RedissonConfig {


    public RedissonClient redissonClient(RedissonProperties properties) {
        if (properties.getServerAddress() == null) {
            return null;
        }
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig
                //可以用"rediss://"来启用SSL连接
                .setAddress(properties.getServerAddress() + ":" + properties.getPort())
                .setPassword(properties.getPassword());
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }


}
