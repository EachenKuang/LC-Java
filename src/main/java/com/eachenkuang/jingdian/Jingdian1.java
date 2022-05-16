package com.eachenkuang.jingdian;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eachenkuang
 * @date 2022/5/2 10:18 上午
 * @description:
 */
public class Jingdian1 {
    public boolean isUnique(String astr) {
        Map<Character, Boolean> dict = new HashMap<>();
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (dict.containsKey(c)) {
                return false;
            }
            dict.put(c, true);
        }
        return true;
    }

    /**
     * 如果只有a-z 26个字母，可以使用一个 int 型整数表示 32位
     * @param astr
     * @return
     */
    public boolean isUnique1(String astr) {
        int check = 0;
        for (int i = 0; i < astr.length(); i++) {
            char ch = astr.charAt(i);
            if (0 != (check & (1 << ch - 'a'))) {
                return false;
            }
            check |= (1 << (ch - 'a'));
        }
        return true;
    }

    /**
     * 128个Ascll 使用两个 long 型整数来 表示128位
     * @param astr
     * @return
     */
    public boolean isUnique2(String astr) {
        long left = 0;
        long right = 0;
        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long bitIndex = 1L << (c - 64);
                if ((left & bitIndex) != 0) {
                    return false;
                }
                left |= bitIndex;
            } else {
                long bitIndex = 1L << c;
                if ((right & bitIndex) != 0) {
                    return false;
                }
                right |= bitIndex;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Jingdian1 jingdian1 = new Jingdian1();
        assert !jingdian1.isUnique("xaxaxaa");
        assert jingdian1.isUnique("abcde");

        assert !jingdian1.isUnique1("xaxaxaa");
        assert jingdian1.isUnique1("abcde");
    }
}
