package com.eachenkuang.jingdian;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eachenkuang
 * @date 2022/5/15 11:18 上午
 * @description:
 */
public class Jingdian4 {
    /**
     * 是否是排列回文串
     * 说明，在所有的字符中，最多只有一个字符的数量是奇数个。
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> char2count = new HashMap<>();
        for (char aChar : chars) {
            if (char2count.containsKey(aChar)) {
                char2count.put(aChar, char2count.get(aChar) + 1);
            } else {
                char2count.put(aChar, 1);
            }
        }
        boolean foundOdd = false;
        for (Integer v: char2count.values()) {
            if (v % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    /**
     * 如果是Ascll 🐴，用一个128长度数组来表示
     * @param s
     * @return
     */
    public boolean canPermutePalindrome2(String s) {
        int[] table = new int[128];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            table[aChar] ++;
        }
        boolean foundOdd = false;
        for (int v: table) {
            if (v % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Jingdian4 jingdian4 = new Jingdian4();
        boolean result1 = jingdian4.canPermutePalindrome("tactcoa");
        boolean result2 = jingdian4.canPermutePalindrome("aaab");

        boolean result3 = jingdian4.canPermutePalindrome2("tactcoa");
        boolean result4 = jingdian4.canPermutePalindrome2("aaab");


    }
}
