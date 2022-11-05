package com.eachenkuang.swordoffer.sw1;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定target=5，返回true。
 *
 * 给定target=20，返回false。
 *
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * @author eachenkuang
 * @date 2022/1/26 7:13 下午
 * @description:
 */
public class Sword04 {
    /**
     * 方法一：
     * 一行一行遍历
     * 时间复杂度 O(n^2)
     * @param matrix
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法二：
     * 从左下角（或者右上角，情况刚好相反）开始出发，根据比较的结果进行操作
     * - 如果当前这等于target，则返回true，
     * - 如果当前值大于target，则向上移动，注意边界问题，继续比较；
     * - 如果当前值小于target，则向右移动，注意边界问题，继续比较；
     * 如果出界，则返回 false
     * 时间复杂度为：O(n)
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray_2(int[][] matrix, int target) {
        int collum = matrix.length;
        if (collum == 0) {
            return false;
        }
        int row = matrix[0].length;
        int i = collum - 1;
        int j = 0;

        while (i >= 0 && j < row) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                // 向上移动
                i--;
            } else {
                // 向右移动
                j++;
            }
        }
        return false;
    }
}
