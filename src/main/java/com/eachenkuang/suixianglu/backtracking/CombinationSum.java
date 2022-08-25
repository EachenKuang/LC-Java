package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/8/25 11:16 AM
 * @description:
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();

    /**
     * 最朴素的回溯法 1
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates, 0, target, 0);
        return results;
    }

    public void backTracking(int[] candidates, int sum, int target, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            results.add(new ArrayList<>(paths));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            paths.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, sum, target, i);
            sum -= candidates[i];
            paths.remove(paths.size()-1);
        }
    }

    /**
     * 优化剪枝
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backTracing2(candidates, target, 0);
        return results;
    }

    public void backTracing2(int[] candidates, int target, int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            results.add(new ArrayList<>(paths));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            paths.add(candidates[i]);
            backTracing2(candidates, target - candidates[i], i);
            paths.remove(paths.size()-1);
        }
    }
}
