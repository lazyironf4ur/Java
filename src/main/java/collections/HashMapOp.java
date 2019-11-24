package collections;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Lazy1ron
 * @date:2019/11/24 17:53
 */
public class HashMapOp {

    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('c', 1);
        map.put('c', 2);
        map.put('c', 3);
        map.put('c', 3);

        //Assert.assertEquals("相同键值对不会添加", 2, map.size());
        Assert.assertEquals("键相同时会覆盖值", 1, java.util.Optional.ofNullable(map.get('c')));
    }
}
