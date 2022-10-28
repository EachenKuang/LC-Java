package com.eachenkuang.leetcode;

import com.eachenkuang.arrays.Solution;

/**
 * @author eachenkuang
 * @date 2022/10/28 19:13
 * @description:
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 */
public class Lc5 {
    /**
     * 动态规划
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * 动态规划
     * dp[i][j] 表示 i-j 之间的字符是否是一个回文子串
     * 递推公式
     * 当 j-i <= 1
     * dp[i][j] = true
     * 当 j-i > 1
     * dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLen = 1;
        int begin  = 0;
        boolean[][] dp = new boolean[length][length];
        // 初始化
//        for (int i = 0; i < length; i++) {
//            dp[i][i] = true;
//        }
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }


    /**
     * 中心扩散法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        String a = "ababbbb";
        System.out.println(longestPalindrome(a));
    }
}
