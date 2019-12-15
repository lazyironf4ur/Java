package utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串转数组对象 TODO
 * @author:Lazy1ron
 * @date:2019/12/14 12:02
 */
public class String2Array {

    // 匹配数组
    private static final String REGEX1 = "[\\[{][a-zA-Z0-9,]*[\\]}]";

    // 匹配所需要获取的文本
    private static final String REGEX2 = "[a-zA-Z0-9]+";


    private static Pattern pattern1 = Pattern.compile(REGEX1);
    private static Pattern pattern2 = Pattern.compile(REGEX2);




    public static String convert(String str) {
        StringBuilder sb = new StringBuilder(str);
        str.replace('1', '9');
        return str;
    }


    /*
     * @Author Lazy1ron
     * @Description: 如果二维数组则需要进行一次包装，如果不是则直接返回
     * @Date 19:22 2019/12/14
     * @Param [str, obs]
     * @return void
     **/
    public static Object[] toStringArray (String str) {
        List<String> list = new ArrayList<>();
        Matcher m1 = pattern1.matcher(str);
        while (m1.find()) {
            list.add(m1.group());
        }
        if (list.size() == 1) {
            Matcher m2 = pattern2.matcher(list.get(0));
            List<String> list1 = new ArrayList<>();
            while (m2.find()) {
                list1.add(m2.group());
            }
            return list1.toArray();
        }

        if (list.size() > 1) {
            Object[] squareArray = new String[list.size()];
            list.forEach((o) -> {
                Matcher m3 = pattern2.matcher(o);
                List<String> list2 = new ArrayList<>();
                while (m3.find()) {
                    list2.add(m3.group());
                }
                squareArray[list.indexOf(o)] = list2.toArray();
            });
            return squareArray;
        }
        return null;
    }



    public static void main(String[] args) {
        int mount = 0;
        String str1 = "[[518,518],[71,971],[121,862],[967,607],[138,754],[513,337],[499,873],[337,387],[647,917],[76,417]]";
        String str2 = "[12366]";
        String str4 = "{132156,asd45}";
        String str3 = "123456.12315";
        //String reg = "\\[\\d+.*\\]";
        String reg1 = "[\\[{][a-zA-Z0-9,]*[\\]}]";
        String reg2 = "(\\[)";

        String reg3 = "[0-9]+";
        //System.out.println(med2big(str1));
        //String reg = "(\\D*)(\\d+)(.*)";
        //Pattern p = Pattern.compile(reg);
        //Matcher m = p.matcher(str1);
        //if (m.find()) {
        //    System.out.println(m.group(0));
        //    System.out.println(m.group(1));
        //    System.out.println(m.group(2));
        //    System.out.println(m.group(3));
        //} else {
        //    System.out.println("No match!");
        //}
        Pattern p1 = Pattern.compile(reg3);
        Matcher m1 = p1.matcher(str1);

        while (m1.find()) {

            System.out.println(m1.group());
        }

        //Matcher m2 = Pattern.compile(reg2).matcher(str1);
        //
        //while (m2.find()) {
        //    System.out.println(m2.start());
        //}

    }

}
