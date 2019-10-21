package algorithm.offer;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author:Lazy1ron
 * @date:2019/10/12 3:50
 */
public class StringDevil {

    public static List<Integer> generatorTenRandom() {
        List<Integer> numbers = new ArrayList<>();
        numbers.stream().map(num -> numbers.add(RandomUtils.nextInt(100, 200))).collect(Collectors.toList());
        return numbers;
    }

    public static void main(String[] args) {
        List<Integer> list = generatorTenRandom();
        System.out.println("11111111");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " ");
        }
    }
}
