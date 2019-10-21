package string;

/**
 * @author:Lazy1ron
 * @date:2019/9/1 10:33
 */
public class StringBuilderOperation {
    public static void main(String[] args) {
        char c[] = {'c','h','i','n','a'};
        StringBuilder sb = new StringBuilder();
        // 在字符串尾部添加
        sb.append("my name is ");
        sb.append("Lazy1ron ");
        sb.append("and i'm ");
        sb.append(18);
        sb.append(" years old. ");
        sb.append("i'm from ");

        sb.append(c);

        System.out.println(sb.toString());
        System.out.println("now i will do some operation");
        // 字符串反转
        sb.reverse();
        System.out.println(sb);
        System.out.println("my god! it reverses!");
        System.out.println("let's turn back");
        sb.reverse();
        // 删除指定区间字符串
        sb.delete(11, 19);
        System.out.println(sb);
        System.out.println("where my name gone!");
        // 从指定位置添加字符串
        sb.insert(11, "Lazy1ron");
        System.out.println(sb);
        System.out.println("now my name is back");
    }
}
