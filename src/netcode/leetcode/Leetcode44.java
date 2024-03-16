package netcode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bryce_dd 2023/12/13 23:31
 */
public class Leetcode44 {

    public static void main(String[] args) {
        System.out.println(isTrue("asdfasdfhghgabdd", "*hg*ab"));
    }

    public static Boolean isTrue(String a, String p) {
        // 将规则化成数组
        List<String> pList = new ArrayList<>();
        String currentPstr = "^";
        for (int i = 0; i < p.length(); i++) {
            String c = String.valueOf(p.charAt(i));
            if ("*".equals(c) || "?".equals(c)) {
                if (!"^".equals(currentPstr)) {
                    pList.add(currentPstr);
                }
                currentPstr = c;
            } else {
                currentPstr += c;
            }
        }
        pList.add(currentPstr);
        // *hg ?bd *s ?ab
        // 开始匹配
        int pIndex = 0;
        int length = a.length();
        boolean result = true;
        int i = 0;
        while (i < length) {
            // 去匹配规则
            String rule = null;
            if (pIndex < pList.size()) {
                rule = pList.get(pIndex);
            }
            // 规则取完还有未匹配的字母返回false，若刚好取完返回true
            if (null == rule) {
                return false;
            }
            // 获取规则格式
            if (rule.startsWith("*")) {
                if (rule.length() == 1) {
                    return true;
                }
                String substring = rule.substring(1);
                String aStr = "";
                int len = substring.length();
                int sIndex = 0;
                while (i < length) {
                    if (len > 0) {
                        if (String.valueOf(substring.charAt(sIndex)).equals(String.valueOf(a.charAt(i)))) {
                            len--;
                            aStr += String.valueOf(substring.charAt(sIndex));
                            sIndex++;
                            i++;
                        } else {
                            aStr = "";
                            len = substring.length();
                            sIndex = 0;
                            i++;
                        }
                    } else {
                        // 当前规则匹配完成，换下一个规则
                        pIndex++;
                        break;
                    }
                }
                if (i == length) {
                    // 走完了出来
                    if (len != 0) {
                        return false;
                    } else {
                        return pIndex == pList.size() - 1;
                    }
                }
            }

            // 另一个规则
        }
        return true;
    }
}
