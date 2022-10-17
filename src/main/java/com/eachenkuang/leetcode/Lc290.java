package com.eachenkuang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author eachenkuang
 * @date 2022/10/17 09:18
 * @description:
 * 给定一种规律 pattern和一个字符串s，判断 s是否遵循相同的规律。
 *
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串s中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 
 *
 * 示例1:
 *
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 */
public class Lc290 {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!Objects.equals(map.get(pattern.charAt(i)), words[i])) {
                    return false;
                }
            } else {
                if (set.contains(words[i])) {
                    return false;
                } else {
                    map.put(pattern.charAt(i), words[i]);
                    set.add(words[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
}
