package com.eachenkuang.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/10/10 09:33
 * @description:
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 这题与118不同之处在于，获取对应索引的行即可。
 */
public class Lc119 {
    /**
     *  可以直接复用118的方法
     */
    public static List<Integer> getRow(int rowIndex) {
        if (rowIndex <= 0) {
            return null;
        }
        return Lc118.generate2(rowIndex).get(rowIndex-1);
    }

    /**
     * 动态规划，倒序更新
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp,1);
        for(int i = 2;i < dp.length;i++){
            for(int j = i - 1;j > 0;j--)
                dp[j] = dp[j] + dp[j - 1];
        }
        return Arrays.asList(dp);
    }

    public static void main(String[] args) {
        int rowIndex = 5;
        System.out.println(getRow(rowIndex));
    }
}
