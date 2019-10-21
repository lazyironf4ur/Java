package inherit;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author:Lazy1ron
 * @date:2019/9/1 11:23
 */
public class test {
    private static boolean isEquals = false;
    @Test
    public void compare() {
        Parent parent1 = new Parent("niko", 18);
        Parent parent2 = new Parent("s1mple", 20);
        Son son1 = new Son("niko", 18);
        Son son2 = new Son("niko", 18);
        if (son1.equals(son2)) isEquals = true;
        int result = parent1.compare(parent2);
        System.out.println("result: " + result);
        System.out.println("isEquals: " + isEquals);
    }
    @Test
    public void set() {
        Son son1 = new Son("niko", 18);
        Son son2 = new Son("niko", 18);
        HashSet<Son> sons = new HashSet<>();
        sons.add(son1);
        sons.add(son2);
        son1.compareTo(son2);
        sons.forEach(System.out::println);
    }
    @Test
    public void linklist() {
        Set<String> strings = new HashSet<>();
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        List<String> list = new LinkedList<>();
        list.addAll(strings);
    }
}
