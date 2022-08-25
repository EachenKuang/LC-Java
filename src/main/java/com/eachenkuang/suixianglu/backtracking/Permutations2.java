package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/8/25 5:17 PM
 * @description:
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *  
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 */
public class Permutations2 {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();

    /**
     * 重复的需要先排序，然后做一些去重逻辑
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length]; // 记录每个数是否被使用过
        Arrays.sort(nums);
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
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
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
        Permutations2 solution = new Permutations2();
        int[] nums = {1,2,2,1,2};
        System.out.print(solution.permuteUnique(nums));
    }
}
