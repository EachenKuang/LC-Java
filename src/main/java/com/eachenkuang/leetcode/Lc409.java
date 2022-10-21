package com.eachenkuang.leetcode;

/**
 * @author eachenkuang
 * @date 2022/10/21 09:14
 * @description:
 * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的 最长的回文串。
 *
 * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
 *
 * 
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 *
 * 输入:s = "a"
 * 输入:1
 * 
 *
 * 提示:
 *
 * 1 <= s.length <= 2000
 * s只由小写 和/或 大写英文字母组成
 *
 * 链接：https://leetcode.cn/problems/longest-palindrome
 */
public class Lc409 {
    /**
     * 计数法，先计算出所有字母的个数，然后计算出奇数和偶数的个数
     * 最终数为
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        int[] count = new int[52];
        int result = 0;
        for (char ch: s.toCharArray()
             ) {
            if (ch >= 'a') {
                count[ch-'a'] ++;
            } else {
                count[ch-'A'+26]++;
            }
            result++;
        }
        int oddCount = 0;
        for (int j : count) {
            if (j % 2 == 1) {
                oddCount++;
            }
        }
        return result - (Math.max(oddCount - 1, 0));
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(longestPalindrome(s));
    }
}
