package com.eachenkuang.leetcode;

/**
 * @author eachenkuang
 * @date 2022/10/20 09:07
 * @description:
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t中被添加的字母。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 * 
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 *
 * 链接：<a href="https://leetcode.cn/problems/find-the-difference">...</a>
 */
public class Lc389 {
    /**
     * Hash法
     * 使用一个26长度的数组来表示
     * 对于s，每次遍历字符，对数组对应字母index的值进行+1操作
     * 对于t，每次遍历字符，对数组对应字母index的值进行-1操作
     * 如果出现-1，则说明当前字符为添加的字母
     *
     * 时间复杂度 O(N) N为s+t的长度
     * 空间复杂度 O(26) 长度固定
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (char c: s.toCharArray()
             ) {
            map[c - 'a']++;
        }
        for (char c: t.toCharArray()
        ) {
            map[c - 'a']--;
            if (map[c - 'a'] == -1) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 求和法
     * 将s 的ASCLL码和与 t 的ASCLL码和想见即可知道对应的字符
     * 时间复杂度 O(N) N为s+t的长度
     * 空间复杂度 O(1)
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference2(String s, String t) {
        char result = 0;
        for (char ch: s.toCharArray()
             ) {
            result -= ch;
        }
        for (char ch: t.toCharArray()
             ) {
            result += ch;
        }
        return result;
    }

    /**
     * 位运算
     * 这道题符合，只有一个单张，其余都成对的题目，通过全部进行异或运算，即可得到单张
     * 时间复杂度 O(N) N为s+t的长度
     * 空间复杂度O(1)
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference3(String s, String t) {
        char result = 0;
        for (char ch: s.toCharArray()
        ) {
            result ^= ch;
        }
        for (char ch: t.toCharArray()
        ) {
            result ^= ch;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "";
        String t = "y";
        System.out.println(findTheDifference(s, t));
        System.out.println(findTheDifference2(s, t));
        System.out.println(findTheDifference3(s, t));
    }
}
