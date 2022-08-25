package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/8/25 2:37 PM
 * @description:
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromePartitioning {
    List<List<String>> results = new ArrayList<>();
    List<String> paths = new ArrayList<>();

    int[][] memo;
    public List<List<String>> partition(String s) {
        memo = new int[s.length()][s.length()];
        backTracking(s, 0);
        return results;
    }

    public void backTracking(String s, int startIndex) {
        // 如果起始位置已经大于s的大小，说明已经找到了一组分割方案了
        if (startIndex >= s.length()) {
            results.add(new ArrayList<>(paths));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                // 如果切割的子串符合回文，则加进去
                paths.add(s.substring(startIndex, i+1));
            } else {
                continue;
            }
            backTracking(s, i+1); // 下个迭代
            paths.remove(paths.size()-1); // 回溯
        }
    }

    /**
     * 是否是回文串，
     * 优化：
     * 1、这里其实可以先预处理下 i,j 是否是回文串，不需要每次都计算，使用DP方法计算出 dp[i][j] 的值
     * 2、或者使用一个备忘录模式，用1表示是回文串，-1表示不是，0表示未初始化，计算时先获取，然后保存
     * @param s
     * @return
     */
    public boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public boolean isPalindrome2(String s, int start, int end) {
        if (memo[start][end] == 1) {
            return true;
        }
        if (start >= end) {
            memo[start][end] = 1;
            return true;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                memo[start][end] = -1;
                return false;
            }
            start++;
            end--;
        }
        memo[start][end] = 1;
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solution = new PalindromePartitioning();
        String s1 = "aba";
        String s2 = "aav";
        assert solution.isPalindrome(s1, 0, 2);
        assert !solution.isPalindrome(s2, 0, 2);
    }
}
