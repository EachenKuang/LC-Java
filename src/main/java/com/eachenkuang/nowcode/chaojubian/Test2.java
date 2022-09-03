package com.eachenkuang.nowcode.chaojubian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author eachenkuang
 * @date 2022/9/3 09:52
 * @description:
 * // 第一行，表示买水果的的重量 3， 2
 * // 第二行，表示水果对应单买的价格 2 5
 * // 第三行，表示套餐一：3 1 6  3斤A和1斤B 总价 6
 * // 第四行, 表示套餐二：1 2 10 1斤A和2斤B 总价 10
 *
 * // 约束
 * // 水果种类不超过10个
 * // 套餐类型不超过10个
 * // 不能多购买水果！！！记住哈，一定要一致
 * // 所有出现的数组小于 1000 范围
 */
public class Test2 {

    /**
     * 实际上这个是一个背包问题，只不过是有两个维度的背包，需要满足
     * @return
     */
    public static int buy(int weightA, int weightB, int priceA, int priceB, int[] comp1, int[] comp2) {
        int[][] dp = new int[weightA+1][weightB+1];
        // 初始化 dp[0][j] dp[i][0]
        for (int i = 1; i < weightA+1; i++) {
            dp[i][0] = priceA * i;
        }
        for (int i = 0; i < weightB+1; i++) {
            dp[0][i] = priceB * i;
        }
        for (int i = 1; i < weightA+1; i++) {
            for (int j = 1; j < weightB+1; j++) {
                // 单买
                dp[i][j] = Math.min(
                        dp[i][j-1] + priceB,
                        dp[i-1][j] + priceA
                );
                // 套餐1
                if (i >= comp1[0] && j >= comp1[1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - comp1[0]][j-comp1[1]] + comp1[2]);
                }
                // 套餐2
                if (i >= comp2[0] && j >= comp2[1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - comp2[0]][j-comp2[1]] + comp2[2]);
                }
            }
        }
        return dp[weightA][weightB];
    }

//    3 2
//            2 5
//            3 1 6
//            1 2 10
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String weightStr = sc.nextLine();
        String[] weightList = weightStr.split(" ");
        int[] weights = new int[weightList.length];
        for (int i = 0; i < weightList.length; i++) {
            weights[i] = Integer.parseInt(weightList[i]);
        }
        String priceStr = sc.nextLine();
        String[] priceList = priceStr.split(" ");
        int[] price = new int[weightList.length];
        for (int i = 0; i < weightList.length; i++) {
            price[i] = Integer.parseInt(priceList[i]);
        }
        int[][] composition = new int[10][weightList.length+1];
        int count = 0;
        while (sc.hasNextInt()) {
            String temp = sc.nextLine();
            String[] compStr = temp.split(" ");
            for (int i = 0; i < weightList.length+1; i++) {
                composition[count][i] = Integer.parseInt(compStr[i]);
            }
            count++;
        }

//        System.out.print(buy2(weights,price,composition,count));
    }

    /**
     * 使用回溯试试
     * @param weights
     * @param prices
     * @param compositions
     * @return
     */
    public int buy2(int[] weights, int[] prices, int[][] compositions, int count) {
        // 先判断所有套餐是否优惠，暂时可以不考虑
        int[] curWeight = new int[weights.length];
        backtrack(weights, prices, compositions, curWeight, count);
        int temp = Integer.MAX_VALUE;
        for (int result: results
             ) {
            temp = Math.min(temp, result);
        }
        return temp;
    }

    List<Integer> results = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();
    public void backtrack(int[] weights, int[] prices, int[][] compositions, int[] curWeight, int count) {
        if (near(weights, curWeight)) {
            // 超过，则退出
            return;
        }
        // 计算一次结果
        int temp = 0;
        for (int path: paths
             ) {
            temp += compositions[path][compositions[path].length-1];
        }
        for (int i = 0; i < weights.length; i++) {
            temp += (weights[i] - curWeight[i]) * prices[i];
        }
        results.add(temp);

        for (int i = 0; i < count; i++) {
            weightAdd(compositions, curWeight, i);
            paths.add(i);
            backtrack(weights, prices, compositions, curWeight, count);  // 下一级递归

            paths.remove(paths.size()-1);
            weightMinus(compositions, curWeight, i); // 回溯
        }
    }

    private void weightMinus(int[][] compositions, int[] curWeight, int index) {
        for (int i = 0; i < curWeight.length; i++) {
            curWeight[i] -= compositions[index][i];
        }
    }

    public boolean near(int[] weights, int[] curWeight) {
        for (int i = 0; i < weights.length; i++) {
            if (curWeight[i] > weights[i]) {
                return false;
            }
        }
        return true;
    }

    public void weightAdd(int[][] compositions, int[] curWeight, int index) {
        for (int i = 0; i < curWeight.length; i++) {
            curWeight[i] += compositions[index][i];
        }
    }
}
