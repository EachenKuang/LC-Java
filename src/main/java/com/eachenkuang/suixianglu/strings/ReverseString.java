package com.eachenkuang.suixianglu.strings;

/**
 * @author eachenkuang
 * @date 2022/8/22 12:13 PM
 * @description:
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        int n = s.length / 2;
        for (int i = 0; i < n; i++) {
            char temp = s[s.length-1];
            s[s.length - 1 - i] = s[i];
            s[i] = temp;
        }
    }
}
