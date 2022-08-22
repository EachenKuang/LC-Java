package com.eachenkuang.suixianglu.strings;

import java.util.Objects;

/**
 * @author eachenkuang
 * @date 2022/8/22 3:12 PM
 * @description:
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
 *
 * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
 *
 * 说明: 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;

    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }


    /**
     * 基于窗口滑动的算法
     * <p>
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     * 注：n为haystack的长度，m为needle的长度
     */
    public int strStr2(String haystack, String needle) {
        int m = needle.length();
        // 当 needle 是空字符串时我们应当返回 0
        if (m == 0) {
            return 0;
        }
        int n = haystack.length();
        if (n < m) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < n - m + 1) {
            // 找到首字母相等
            while (i < n && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }
            if (i == n) {// 没有首字母相等的
                return -1;
            }
            // 遍历后续字符，判断是否相等
            i++;
            j++;
            while (i < n && j < m && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {// 找到
                return i - j;
            } else {// 未找到
                i -= j - 1;
                j = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        int result = strStr.strStr("aabaabaaf", "aabaaf");
        System.out.print(result);
    }
}