package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/8/25 4:02 PM
 * @description:
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return results;
    }

    public void backTracking(int[] nums, int startIndex) {
        results.add(new ArrayList<>(paths));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            paths.add(nums[i]);    // 子集收集元素
            backTracking(nums, i + 1);  // 注意从i+1开始，元素不重复取
            paths.remove(paths.size()-1);            // 回溯
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.print(subsets.subsets(nums));
    }
}
