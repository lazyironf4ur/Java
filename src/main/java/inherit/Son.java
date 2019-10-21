package inherit;


import java.util.Random;

/**
 * @author:Lazy1ron
 * @date:2019/9/1 11:09
 */
public class Son extends Parent implements Comparable<Son> {
    private static final String randomName = "abcdefghijkABCDEFGHIJK123456789";
    private static final String randomAge = "123456789";

    public Son() {
        super();
    }

    public Son(String name, Integer age) {
        super(name, age);
    }


    @Override
    public int compareTo(Son o) {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        Son son = (Son) obj;
        boolean isTrue = false;
        if (son.getName() == this.getName()) isTrue = true;
            return isTrue;
    }

    @Override
    public int hashCode() {
        int code = 0;
        code = this.getName().hashCode();
        return code;
    }

    public static Son RandomSon() {
        Random random = new Random();
        int num = random.nextInt(3) + 1;
        StringBuilder name = new StringBuilder();
        StringBuilder age = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            name.append(randomName.charAt(random.nextInt(randomName.toCharArray().length)));
        }

        for (int x = 0; x < num; x++) {
            Integer rage = 0;
            rage = Integer.valueOf(randomAge.charAt(random.nextInt(randomAge.toCharArray().length))) - 48;
            age.append(rage);
        }
        return new Son(name.toString(), Integer.valueOf(age.toString()));
    }
}
