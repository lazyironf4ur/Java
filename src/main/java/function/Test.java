package function;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author:Lazy1ron
 * @date:2020/1/16 21:39
 */
public class Test {

    private static void fortest(Consumer<Set<String>> action, Predicate<Set<String>> result) {
        Set<String> strings = new HashSet<>();
        action.accept(strings);
        strings.forEach(System.out::println);
        Assert.assertEquals("OK!", true, result.test(strings));

    }

    public static void main(String[] args) {
        String name = "lazy1ron";
        fortest(set -> set.add(name), set -> set.contains(name));
    }
}
