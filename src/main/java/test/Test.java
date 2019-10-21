package test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author:Lazy1ron
 * @date:2019/9/18 21:16
 */
public class Test {
    @org.junit.Test
    public void DateUtils() {
        Long temp;
        String date;
//        temp = new Date(1_778_410_800_000L).getTime() - new Date(1_515_585_600_000L).getTime();
        //                1_778_414_400_000L
//        date = new Date(1_515_585_600_000L).toString();
//        System.out.println(new Date(1_778_410_800_000L));
//        System.out.println(new Date());
//        System.out.println(new Date(1000L));
//        System.out.println(new Date(1_515_585_600_000L).toString());
//        System.out.println(date);
//        System.out.println("时间差：" + temp);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(1_515_585_600_000L));
        calendar.add(2, 100);
        temp = calendar.getTime().getTime();
        System.out.println(temp);
    }
}
