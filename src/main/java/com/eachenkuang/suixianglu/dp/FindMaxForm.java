package com.eachenkuang.suixianglu.dp;

/**
 * @author eachenkuang
 * @date 2022/8/29 8:28 PM
 * @description:
 */
public class FindMaxForm {
    public static int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strings = {"10", "0001", "111001", "1", "0"};
        int m = 3;
        int n = 3;
        System.out.print(findMaxForm(strings, m, n));
    }
}
