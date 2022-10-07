package com.eachenkuang.leetcode;

class Lc14 {

    /**
     * 横向比较
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }


    // 纵向比较
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 先找到最短的字符
        int minLength = Integer.MAX_VALUE;
        int longestPrefix = 0;
        for(String str: strs) {
            minLength = Math.min(str.length(), minLength);
        } 
        for (int i = 0; i < minLength; i++) {
            char curr = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != curr) {
                    return strs[0].substring(0, longestPrefix);
                }
            }
            longestPrefix++;
        }
        return strs[0].substring(0, longestPrefix);
    }

    /**
     * 纵向比较
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"leec", "lee", "legihjy"};
        System.out.println(longestCommonPrefix(strs));
    }
}