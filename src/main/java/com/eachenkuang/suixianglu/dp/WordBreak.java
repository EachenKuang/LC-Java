package com.eachenkuang.suixianglu.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author eachenkuang
 * @date 2022/9/1 11:10
 * @description:
 */
public class WordBreak {
    /**
     * 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1]; // dp[i] 表示0~i是否可以切分成 wordDict中的字符串
        dp[0] = true;  // 递推的根本，本身无含义
        // 遍历背包
        for (int i = 1; i < s.length() + 1; i++) {
            // 遍历物品
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (wordDictSet.contains(word) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "LeetCode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("Leet", "Code"));
        System.out.print(wordBreak(s, wordDict));
    }
}
