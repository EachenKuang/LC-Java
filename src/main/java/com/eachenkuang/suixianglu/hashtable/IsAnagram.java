package com.eachenkuang.suixianglu.hashtable;

/**
 * @author eachenkuang
 * @date 2022/8/22 9:43 AM
 * @description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 * 说明: 你可以假设字符串只包含小写字母。
 */
public class IsAnagram {
    /**
     * 通过计算 s, t中的字母元素个数来判断
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        int[] alphas = new int[26];
        for (char c: s.toCharArray()) {
            alphas[c -'a'] += 1;
        }
        for (char c: t.toCharArray()) {
            alphas[c- 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (alphas[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aba";
        String t = "aab";
        assert  isAnagram(s, t);
    }
}
