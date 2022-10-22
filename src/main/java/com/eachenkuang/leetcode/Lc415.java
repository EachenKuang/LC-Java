package com.eachenkuang.leetcode;

/**
 * @author eachenkuang
 * @date 2022/10/22 12:38
 * @description:
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 *
 * 
 *
 * 示例 1：
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *
 *
 * 链接：https://leetcode.cn/problems/add-strings
 */
public class Lc415 {
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int length1 = num1.length();
        int length2 = num2.length();
        int maxLength = Math.max(length1, length2);

        int carry = 0;
        for (int i = 0; i < maxLength; i++) {
            int a = 0, b = 0;
            if (i < length1) {
                a = num1.charAt(length1-i-1) - '0';
            }
            if (i < length2) {
                b = num2.charAt(length2-i-1) - '0';
            }
            int sum = a + b + carry;
            // 重置 carry
            carry = 0;
            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }
            sb.append(sum);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "999";
        System.out.println(addStrings(num1, num2));
    }
}
