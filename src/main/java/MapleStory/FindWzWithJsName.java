package MapleStory;

import tools.StringUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FindWzWithJsName {

    private static String JS_NAME = "450001005";
    public static void main(String[] args){
        System.out.println(getMapXMLName(Integer.valueOf(JS_NAME)));
    }

    private static String getMapXMLName(int mapid) {
        String mapName = StringUtil.getLeftPaddedStr(Integer.toString(mapid), '0', 9);
        String builder = "Map/Map" + mapid / 100000000 +
                "/" +
                mapName +
                ".img";
        mapName = builder;
        return mapName;
    }
}