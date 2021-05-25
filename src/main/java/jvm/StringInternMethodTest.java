package jvm;

/**
 * @author:Lazy1ron
 * @date:2020/7/26 1:57
 */
public class StringInternMethodTest {


    //intern 方法返回的是常量池中字符串的应用，并不是对象(java堆)的应用
    public static void main(String[] args) {
        //String str1 = new StringBuilder("计算机").append("软件").toString();
        //
        //System.out.println(str1.intern() == str1);

        // java 这个字符串已经存在于常量池中，所以str2.intern()返回的应用不是
        //String str2 = new StringBuilder("ja").append("va").toString();
        //
        //System.out.println(str2.intern() == str2);

        String str3 = "asd";
        System.out.println(str3.intern() == str3);

        String str4 = new String("asd");

        String str6 = str4;
        //
        //String str5 = new StringBuilder("a").append("sd").toString();
        //
        System.out.println(str4.intern() == str4);
        //
        //System.out.println(str3 == str4);
        //
        //System.out.println("toString: " + str5.intern() == str3);
        //System.out.println("toString: " + str5.intern() == str3.intern());
        //
        //System.out.println(str5 == str3);
        System.out.println(str4.intern() == str3);
        System.out.println(str6.intern() == str4);
        //System.out.println(str3.intern() == str4);
    }
}
