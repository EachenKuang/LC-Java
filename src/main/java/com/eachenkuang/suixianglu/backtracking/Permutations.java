package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/8/25 5:17 PM
 * @description:
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 */
public class Permutations {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length]; // 记录每个数是否被使用过
        backTracking(nums, used);
        return results;
    }

    public void backTracking(int[] nums, boolean[] used) {
        // paths中的元素与数组相同，则说明是全排列
        if (paths.size() == nums.length) {
            results.add(new ArrayList<>(paths));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            paths.add(nums[i]);
            backTracking(nums, used);  // 下一层递归
            paths.remove(paths.size()-1); // 回溯
            used[i] = false;  // 回溯
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] nums = {1,2,3};
        System.out.print(solution.permute(nums));
    }
}
