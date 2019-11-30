package algorithm.leetcode.high;

import org.junit.Assert;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * TODO: 15 / 1809 个通过测试用例 超时
 *
 * @author:Lazy1ron
 * @date:2019/11/29 15:03
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        if (p.equals("*")) return true;
        if (p.length() != s.length() && !p.contains("*")) return false;
        int i = 0, j = 0;
        int temi = 0, temj = 0;
        boolean flag = true;
        boolean flag2 = false;
        // 判断当i到达最大深度，并且出现无法匹配的情况，则表示无法匹配
        boolean flag3 = true;
        boolean flag4 = true;
        while (i <= s.length() && !flag2 && flag && flag3) {
            if (i == s.length() && j < p.length()) {
                for (int z = j; z < p.length(); z++) {
                    if (p.charAt(z) != '*') {
                        flag = false;
                        break;
                    }
                }
                break;
            }
            if (j == p.length() || i == s.length()) {
                flag4 = false;
                break;
            }

            if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
                if (j == p.length() - 1 && i == s.length() - 1) {
                    flag4 = true;
                    break;
                }
                if (j >= 1 && p.charAt(j - 1) == '*') {
                    temi = i;
                    temj = j;
                }
                i++;
                j++;
                continue;
            } else {
                switch (p.charAt(j)) {
                    case '*':
                        if (j == p.length() - 1) flag2 = true;
                        else j++;
                        break;
                    default:
                        if (j >= 1 && p.charAt(j - 1) == '*' && i < s.length() - 1) {

                            i++;
                        } else {
                            // 这里不能直接跳出循环，只能断定当前分支路径不匹配
                            if (temi + temj != 0)  {
                                i = temi + 1;
                                j = temj;
                            } else {
                                flag3 = false;
                            }
                        }
                }
            }
        }
        if ((flag || flag2) && flag3 && flag4) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Assert.assertEquals(true, new WildcardMatching().isMatch("aa", "a*"));
        Assert.assertEquals(false, new WildcardMatching().isMatch("aa", "a"));
        Assert.assertEquals(false, new WildcardMatching().isMatch("acdcb", "a*c?b"));
        Assert.assertEquals(true, new WildcardMatching().isMatch("adceb", "*a*b"));
        Assert.assertEquals(true, new WildcardMatching().isMatch("adceb", "*a*b*****************"));
        Assert.assertEquals(true, new WildcardMatching().isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
        Assert.assertEquals(false, new WildcardMatching().isMatch("abefcddgiescdfimdee", "ab*cd?i*de"));


    }
}
