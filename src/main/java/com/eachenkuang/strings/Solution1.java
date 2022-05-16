package com.eachenkuang.strings;

/**
 * @author eachenkuang
 * @date 2022/2/19 11:00 上午
 * @description:
 */
public class Solution1 {
    /**
     * 双指针法
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s.length() == 0)
            return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            //因为题中说了，只考虑字母和数字，所以不是字母和数字的先过滤掉
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            //然后把两个字符变为小写，在判断是否一样，如果不一样，直接返回false
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
