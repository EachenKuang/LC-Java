package com.eachenkuang.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author eachenkuang
 * @date 2022/10/20 09:07
 * @description:
 * 
 * 给定一个字符串s，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1。
 *
 * 
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 * 
 *
 * 提示:
 *
 * 1 <= s.length <= 105
 * s只包含小写字母
 *
 *
 * 链接：https://leetcode.cn/problems/first-unique-character-in-a-string
 */
public class Lc387 {
    /**
     * 需要保存顺序，需要记录是否重复
     * O(N)
     * O(26)
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int[] count = new int[26]; // 保存出现的次数
        for (char ch: s.toCharArray()) {
            count[ch-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "abcabcm";
        System.out.println(firstUniqChar(s));
    }
}
