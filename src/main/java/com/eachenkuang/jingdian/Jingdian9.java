package com.eachenkuang.jingdian;

/**
 * @author eachenkuang
 * @date 2022/9/27 16:46
 * @description:
 */
public class Jingdian9 {
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s1);
        sb.append(s1);
        return sb.toString().contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "cdab";
        System.out.println(isFlipedString(s1, s2));
    }
}
