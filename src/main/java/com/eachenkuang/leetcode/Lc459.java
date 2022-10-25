package com.eachenkuang.leetcode;

import com.eachenkuang.arrays.Solution;

/**
 * @author eachenkuang
 * @date 2022/10/25 09:28
 * @description:
 * 给定一个非空的字符串s，检查是否可以通过由它的一个子串重复多次构成。
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
 * 链接：https://leetcode.cn/problems/repeated-substring-pattern
 *
 * 可以参见 class RepeatedSubstringPattern com.eachenkuang.suixianglu.strings.RepeatedSubstringPattern
 */
public class Lc459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
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
}
