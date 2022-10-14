package com.eachenkuang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author eachenkuang
 * @date 2022/10/14 09:13
 * @description:
 *  * 给定两个字符串s和t，判断它们是否是同构的。
 *  *
 *  * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 *  *
 *  * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *  *
 *  *
 *  *
 *  * 示例 1:
 *  *
 *  * 输入：s = "egg", t = "add"
 *  * 输出：true
 *  * 示例 2：
 *  *
 *  * 输入：s = "foo", t = "bar"
 *  * 输出：false
 *  * 示例 3：
 *  *
 *  * 输入：s = "paper", t = "title"
 *  * 输出：true
 */
public class Lc205 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> dict = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char former = s.charAt(i);
            char latter = t.charAt(i);
            if (dict.containsKey(former)) {
                if (dict.get(former) != latter) {
                    return false;
                }
            } else {
                if (set.contains(latter)) {
                    return false;
                }
                set.add(latter);
                dict.put(former, latter);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "foo";
        String t = "cba";
        System.out.println(isIsomorphic(s, t));
    }
}
