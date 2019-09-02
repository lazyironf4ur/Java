package string;

/**
 * @author:Lazy1ron
 * @date:2019/9/1 9:12
 */
public class StringOperation {

    public static void main(String[] args) {
        // 反转字符串
        String s = "run noob";
        String reverse = new StringBuilder(s).reverse().toString();
        System.out.println("reverse: " + reverse);
        // 找到字符串一个字符所在的索引
        int indexof = s.indexOf("noob");
        System.out.println("index of: " + indexof);
        // 替换所用字符
        String replace = s.replace('o', 'a');
        System.out.println("replace: " + replace);
        // 替换所有与regex匹配的子串
        String replaceFirst = s.replaceFirst("run", "fast run");
        System.out.println("replaceFirst: " + replaceFirst);
        // 字符串分割
        String[] split = s.split(" ");
        System.out.print("split: ");
        for (String s1 : split) {
            System.out.print(s1 + " | ");
        }
        // 字符串类型转基本数据类型
        String pr = "10.05f";
        float price = Float.parseFloat(pr);
        System.out.println("\nprice: " + price);
        // 基本数据类型转字符串
        double dou = 5683.0005d;
        String douTostr = String.valueOf(dou);
        System.out.println("douTostr: " + douTostr);
    }
}
