package com.eachenkuang.leetcode;

/**
 * @author eachenkuang
 * @date 2022/10/12 09:06
 * @description:
 * 给你一个整数columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * 例如：
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * ...
 *
 */
public class Lc168 {
    /**
     * 实际上是转化进制数的一种
     * @param columnNumber
     * @return
     */
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber -= 1;
            char cur = (char) ('A' + columnNumber % 26);
            sb.append(cur);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int columnNumber = 701;
        System.out.println(convertToTitle(columnNumber));
    }
}
