package inherit;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:Lazy1ron
 * @date:2019/9/8 0:29
 */
public class SonCreateService {
    private static List<Son> sons = new ArrayList<>();
    private static Map<Object, Integer> map = new HashMap<>();

    public boolean addListElement(Son son) {
        if (son != null) {
            sons.add(son);
            return true;
        }
        return false;
    }
    public boolean addMapElement(Son son) {
        if (son != null) {
            map.put(son, map.size()+1);
            return true;
        }
        return false;
    }

    public List<Son> getSons() {
        return sons;
    }

    public Map<Object, Integer> getMap() {
        return map;
    }
}
