package com.eachenkuang.suixianglu.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author eachenkuang
 * @date 2022/8/25 4:50 PM
 * @description:
 */
public class FindSubsequences {

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();

    /**
     * 第一想法就是在 子集的基础上，增加一个判断当前集合是否是递增子序列 (不简单，还需要解决重复的子序列)
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return results;
    }

    public void backTracking(int[] nums, int startIndex) {
        // 用来保存本层已经使用过的数，避免重复的集合
        Set<Integer> usedSet = new HashSet<>();
        if (paths.size() >= 2) {
            // 至少需要两个数才能是满足条件的子串
            results.add(new ArrayList<>(paths));
        }
        for (int i = startIndex; i < nums.length; i++) {
            if ((!paths.isEmpty() && nums[i] < paths.get(paths.size()-1)) ||
                    usedSet.contains(nums[i])) {
                continue;
            }
            paths.add(nums[i]);
            usedSet.add(nums[i]);
            backTracking(nums, i + 1);  // 注意从i+1开始，元素不重复取
            paths.remove(paths.size()-1);            // 回溯
        }
    }

    public static void main(String[] args) {
        FindSubsequences solution = new FindSubsequences();
        int[] nums = {4,7,6,7,7};
        System.out.print(solution.findSubsequences(nums));
    }
}
