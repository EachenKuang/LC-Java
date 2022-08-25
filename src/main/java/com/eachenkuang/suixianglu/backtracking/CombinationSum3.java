package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为n 的k个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class CombinationSum3 {

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();

    /**
     * 递归+剪枝
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1);
        return results;
    }

    public void backTracking(int k, int n, int startIndex) {
        if (paths.size() == k) {
            int ans = 0;
            for (int path: paths) {
                ans += path;
            }
            if (ans == n) {
                results.add(new ArrayList<>(paths));
            }
            return;
        }
        for (int i = startIndex; i <= 10 - (k - paths.size()) ; i++) {
            paths.add(i);
            backTracking(k, n, i+1);
            paths.remove(paths.size()-1);
        }
    }

    /**
     * 回溯的优化，target 优化
     *
     * 两个剪枝，
     * 一是，从个数上进行剪枝优化，如果剩余的数不够 paths.size()，则直接返回上层
     * 二是，从target 结果上优化，因为是从1-9选择，所以target大于0，那么当当前所选数大于target，那么也没有必要继续了
     *
     * @param k
     * @param target
     * @param startIndex
     */
    public void backTracing2(int k, int target, int startIndex) {
        if (target == 0 && paths.size() == k) {
            results.add(new ArrayList<>(paths));
            return;
        }
        for (int i = startIndex; i <= 10 - (k - paths.size()) ; i++) {
            // 剪枝
            if (target - i < 0) {
                return;
            }
            paths.add(i);
            backTracing2(k, target - i, i+1);
            paths.remove(paths.size()-1);
        }
    }
    
}
