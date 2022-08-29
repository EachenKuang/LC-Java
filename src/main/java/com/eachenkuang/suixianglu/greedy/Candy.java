package com.eachenkuang.suixianglu.greedy;

import java.util.Arrays;

/**
 * @author eachenkuang
 * @date 2022/8/26 12:40 PM
 * @description:
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 */
public class Candy {
    /**
     * 贪心算法
     * 那么本题我采用了两次贪心的策略：
     * 1.一次是从左到右遍历，只比较右边孩子评分比左边大的情况。
     * 2.一次是从右到左遍历，只比较左边孩子评分比右边大的情况。
     * 这样从局部最优推出了全局最优，即：相邻的孩子中，评分高的孩子获得更多的糖果
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        // 从左往右
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i-1] < ratings[i]) {
                left2right[i] = left2right[i-1] + 1;
            }
        }
        int count = left2right[ratings.length - 1];
        for (int j = ratings.length - 2; j >= 0 ; j--) {
            if (ratings[j+1] < ratings[j]) {
                right2left[j] = right2left[j+1] + 1;
            }
            count += Math.max(left2right[j], right2left[j]);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        Candy solution = new Candy();
        int result = solution.candy(ratings);
        System.out.print(result);
    }
}
