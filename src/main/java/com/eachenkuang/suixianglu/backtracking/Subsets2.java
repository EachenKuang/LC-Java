package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/8/25 4:25 PM
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 示例 1：
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 */
public class Subsets2 {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();

    /**
     * 难点在于去重
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // 首先需要排序
        boolean[] used = new boolean[nums.length]; // 用来保存是否使用过
        backTracking(nums, 0, used);
        return results;
    }

    public void backTracking(int[] nums, int startIndex, boolean[] used) {
        results.add(new ArrayList<>(paths));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // 我们可以通过判断这种情况，来避免生成重复的子集。
            // 代码实现时，可以先将数组排序；迭代时，若发现没有选择上一个数，
            // 且当前数字与上一个数相同，则可以跳过当前生成的子集。
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            paths.add(nums[i]);    // 子集收集元素
            backTracking(nums, i + 1, used);  // 注意从i+1开始，元素不重复取
            paths.remove(paths.size()-1);            // 回溯
            used[i] = false; // 回溯
        }
    }

    /**
     * 不用user数组的情况
     * @param nums
     * @param startIndex
     */
    public void backTracking2(int[] nums, int startIndex) {
        results.add(new ArrayList<>(paths));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // 注意这里与 backTracking 的区别
            // 本题也可以不使用used数组来去重，因为递归的时候下一个startIndex是i+1而不是0
            if (i > startIndex && nums[i] == nums[i-1]) {
                continue;
            }
            paths.add(nums[i]);    // 子集收集元素
            backTracking2(nums, i + 1);  // 注意从i+1开始，元素不重复取
            paths.remove(paths.size()-1);            // 回溯
        }
    }

    public static void main(String[] args) {
        Subsets2 subsets = new Subsets2();
        int[] nums = {1,2,2};
        System.out.print(subsets.subsetsWithDup(nums));
    }
}
