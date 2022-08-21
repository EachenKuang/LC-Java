package com.eachenkuang.suixianglu.arrays;

public class GenerateMatrix {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int start = 0;
        int count = 1; // 定义填充数字
        int loop = 0;
        int i,j;
        while (loop < n/2) {
            loop++;
            for (j = start; j < n - loop; j++) {
                matrix[start][j] = count++;
            }
            for (i = start; i < n - loop; i++) {
                matrix[i][j] = count++;
            }
            for (; j > start; j--) {
                matrix[i][j] = count++;
            }
            for (; i > start; i--) {
                matrix[i][j] = count++;
            }
            start++;
        }
        // 如果是奇数圈，则还需要把中间的数填上
        if (n%2 == 1) {
            matrix[n/2][n/2] = count;
        } 
        return matrix;

    }

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(5);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
}
