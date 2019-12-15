import org.junit.Test;
import utils.String2Array;

import java.util.Arrays;

/**
 * @author:Lazy1ron
 * @date:2019/12/15 9:09
 */
public class String2ArrayTest {


    @Test
    public void test() {
        String str1 = "[[518,518],[71,971],[121,862],[967,607],[138,754],[513,337],[499,873],[337,387],[647,917],[76,417]]";
        String str = "[asd,fasf,asfasf,asfwwa]";
        Object[] strs = String2Array.toStringArray(str1);
        System.out.println(Arrays.toString(strs));
    }

    @Test
    public void test2() {
        String str1 = "[[518,518],[71,971],[121,862],[967,607],[138,754],[513,337],[499,873],[337,387],[647,917],[76,417]]";
        System.out.println(String2Array.convert(str1));
    }
}
