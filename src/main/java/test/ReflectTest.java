package test;

import design.AbstractCsPlayer;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author:Lazy1ron
 * @date:2019/12/16 14:03
 */

public class ReflectTest {

    @Test
    public void test() {
        Constructor[] c = AbstractCsPlayer.class.getConstructors();
        for (int i = 0; i < c.length; i++) {
            System.out.printf("这是第%d构造器: ", i+1);
            Class<?>[] clazz = c[i].getParameterTypes();
            for (int j = 0; j < clazz.length; j++) {
                System.out.print(clazz[j].getName() + " | ");
            }
            System.out.println();
        }
    }

    @Test
    public void test2() {
        Constructor[] c = AbstractCsPlayer.class.getDeclaredConstructors();
    }
}
