package com.eachenkuang.suixianglu.strings;

/**
 * @author eachenkuang
 * @date 2022/8/22 12:30 PM
 * @description:
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 *
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class ReverseStr {
    public static String reverseStr(String s, int k) {
        char[] charList = s.toCharArray();
        for (int i = 0; i < charList.length; i=i+2*k ) {
            if (i+k <= charList.length) {
                reverseString(charList, i, i+k-1);
                continue;
            }
            reverseString(charList, i , charList.length-1);
        }
        return String.valueOf(charList);
    }

    /**
     * 简化版
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr1(String s, int k) {
        char[] charList = s.toCharArray();
        for (int i = 0; i < charList.length; i=i+2*k ) {
            reverseString(charList, i , Math.min(i + k, charList.length) - 1);
        }
        return String.valueOf(charList);
    }

    public static void reverseString(char[] s, int i, int j) {
        while (i < j && i >= 0 && j < s.length) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefghk";
        int k = 3;
        String a = reverseStr(s, k);
        System.out.print(a);
    }
}
