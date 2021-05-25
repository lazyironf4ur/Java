package test;

import java.lang.reflect.Field;

/**
 * @author:Lazy1ron
 * @date:2020/7/6 20:32
 */
public class FieldTest {

    public static void main(String[] args) {

        try {
            Field field = Field.class.getDeclaredField("modifiers");
            System.out.println(field.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
