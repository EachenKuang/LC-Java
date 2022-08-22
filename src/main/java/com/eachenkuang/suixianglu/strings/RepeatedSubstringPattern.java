package com.eachenkuang.suixianglu.strings;

import java.util.Arrays;

/**
 * @author eachenkuang
 * @date 2022/8/22 4:42 PM
 * @description:
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 *
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedSubstringPattern {
    /**
     * 使用暴力法
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        // 这里的 i 表示能够需要进行匹配的子串长度
        for (int i = 1; i * 2 <= n; ++i) {
            // 子串长度一定能够被原字符串长度整除
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将两个字符串拼接起来，如果它是由若干个子串组成的，那么可能存在一个完成的s在新串中间。
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern2(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    public boolean repeatedSubstringPattern3(String s) {
        return kmp(s);
    }

    public boolean kmp(String pattern) {
        int n = pattern.length();
        int[] next = new int[n];
        Arrays.fill(next, -1);
        for (int i = 1; i < n; ++i) {
            int j = next[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = next[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                next[i] = j + 1;
            }
        }
        return next[n - 1] != -1 && n % (n - next[n - 1] - 1) == 0;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        boolean result = repeatedSubstringPattern.repeatedSubstringPattern("abcabcabc");
        System.out.print(result);
        boolean result2 = repeatedSubstringPattern.repeatedSubstringPattern2("abcabcabc");
        System.out.print(result2);
        boolean result3 = repeatedSubstringPattern.repeatedSubstringPattern3("abcabcabc");
        System.out.print(result3);
    }
}
