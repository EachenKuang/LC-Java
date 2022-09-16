package com.eachenkuang.company.jerry;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author eachenkuang
 * @date 2022/9/15 15:01
 * @description:
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数
 *
 * 示例
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class Test1 {
    public static String transfer(String s, int row) {
        if (row <= 0 || s == null) {
            return null;
        }
        int length = s.length();
        if (row == 1 || length <= row) {
            return s;
        }
        int maxLength = length / row - 2;
        List<List<Character>> matrix = new ArrayList<>();
        // 初始化
        for (int i = 0; i < row; i++) {
            matrix.add(new ArrayList<>());
        }
        int curRow = 0;
        boolean down = true;
        for (int i = 0; i < length; i++) {
            matrix.get(curRow).add(s.charAt(i));
            if (curRow == row - 1 && down) {
                // 到达最底层，需要向上
                down = false;
            } else if (curRow == 0 && !down) {
                // 回到最上层，需要向下
                down = true;
            }
            if (down) {
                curRow++;
            } else {
                curRow--;
            }
        }

        // 收集数据
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (char c: matrix.get(i)
                 ) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(transfer(s, 3));
        System.out.println(transfer("A", 1));

        assert Objects.equals(transfer(s, 3), "PAHNAPLSIIGYIR");
    }
}
