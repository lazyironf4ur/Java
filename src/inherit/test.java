package inherit;

import org.junit.Test;

/**
 * @author:Lazy1ron
 * @date:2019/9/1 11:23
 */
public class test {

    @Test
    public void compare() {
        Parent parent1 = new Parent("niko", 18);
        Parent parent2 = new Parent("s1mple", 20);
        int result = parent1.compare(parent2);
        System.out.println("result: " + result);
    }
}
