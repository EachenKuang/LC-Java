package com.eachenkuang.jingdian;

import java.util.Arrays;

/**
 * @author eachenkuang
 * @date 2022/5/2 11:19 上午
 * @description:
 * 判定是否互为字符重排
 */
public class Jingdian2 {

    /**
     * 方法一：
     * 对两个字符串排序，如果两者一致，说明可以重排
     * 时间复杂度：O(NlogN)
     *
     * 方法二：
     * 使用散列表，解析两个字符串，保存起来，key 为字符，value 为数量
     * 比较两个散列表是否完全一致，一致说明可以重排
     * 时间复杂度 O(N)
     *
     * 方法三：
     * 在二的基础上进行优化，只需要一个散列表，先解析一个散列表，第一个执行加法操作，然后第二个进行减法操作，如果出现小于0的情况，说明不能。
     *
     */


    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean CheckPermutation1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] table = new int[128];
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        for (char c1: str1
             ) {
            table[c1] ++;
        }
        for (char c2: str2
             ) {
            table[c2] --;
            if (table[c2] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean CheckPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] table = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i)] ++;
        }
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            table[c] --;
            if (table[c] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Jingdian2 jingdian2 = new Jingdian2();
        assert jingdian2.CheckPermutation("abc", "bac");
        assert !jingdian2.CheckPermutation("abcdd", "dasdas");

        assert jingdian2.CheckPermutation1("abc", "bac");
        assert !jingdian2.CheckPermutation1("abcdd", "dasdas");
        assert jingdian2.CheckPermutation1("", "");
        assert !jingdian2.CheckPermutation1("  1", "1  ");
    }
}
