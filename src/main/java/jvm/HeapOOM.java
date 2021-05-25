package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Lazy1ron
 * @date:2020/7/25 17:50
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
