package com.eachenkuang.leetcode;

/**
 * @author eachenkuang
 * @date 2022/10/13 09:10
 * @description:
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
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
 *
 * 示例 1:
 *
 * 输入: columnTitle = "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: columnTitle = "ZY"
 * 输出: 701
 */
public class Lc171 {
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        int pre;
        for (char ch : columnTitle.toCharArray()
        ) {
            pre = ch - 'A' + 1;
            result = 26 * result + pre;
        }
        return result;
    }

    public static void main(String[] args) {
        String columnTitle = "ZY";
        System.out.println(titleToNumber(columnTitle));
    }
}
