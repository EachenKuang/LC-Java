package com.eachenkuang.suixianglu.dp;

import com.eachenkuang.arrays.Solution;

/**
 * @author eachenkuang
 * @date 2022/9/16 15:51
 * @description:
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 */
public class PalindromicSubstrings {

    /**
     * 暴力法
     * O(N^2)
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

    /**
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
    public static int countSubstrings2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i+1][j-1]) {
                            dp[i][j] = true;
                            result++;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public int countSubstrings3(String s) {
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1) return 0;
        //总共有2 * len - 1个中心点
        for (int i = 0; i < 2 * len - 1; i++) {
            //通过遍历每个回文中心，向两边扩散，并判断是否回文字串
            //有两种情况，left == right，right = left + 1，这两种回文中心是不一样的
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                //如果当前是一个回文串，则记录数量
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }
}
