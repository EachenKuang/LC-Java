package com.eachenkuang.suixianglu.dp;

/**
 * @author eachenkuang
 * @date 2022/9/15 14:34
 * @description:
 */
public class DeleteOperationForTwoStrings {
    /**
     * 动态规划
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        // 初始化 dp[0][j] 与 dp[i][0]
        for (int i = 1; i < word1.length()+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < word2.length()+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // 三种情况，需要删除word1一个，需要删除word2一个，需要删除两个
                    dp[i][j] = Math.min(Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1), dp[i-1][j-1] + 2);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    /**
     * 先使用最长公共子序列的方法来计算，然后减去长度就是了
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[m][n];
        return m - lcs + n - lcs;
    }

    public static void main(String[] args) {
        String w1 = "catcat";
        String w2 = "atat";
        System.out.println(minDistance(w1, w2));
    }
}
