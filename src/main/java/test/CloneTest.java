package test;

import inherit.Parent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Lazy1ron
 * @date:2020/6/30 17:37
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Parent parent1 = new Parent();
        parent1.setAge(18);
        parent1.setName("niko");
        System.out.println(parent1.toString());
        Parent parent2 = (Parent) parent1.clone();
        if (parent2.equals(parent1)) {          // equals 重写过
            System.out.println("they are same thing!");
        }
    }
}
