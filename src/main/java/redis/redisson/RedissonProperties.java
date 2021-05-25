package redis.redisson;

import lombok.Data;
import lombok.Value;

/**
 * @author:Lazy1ron
 * @date:2021/4/27 14:57
 */

@Data
public class RedissonProperties {


    private String serverAddress;

    private String port;

    private String password;
}
