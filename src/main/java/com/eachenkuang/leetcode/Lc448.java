package com.eachenkuang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
示例 1：

输入：nums = [4,3,2,7,8,2,3,1]
输出：[5,6]
示例 2：

输入：nums = [1,1]
输出：[2]
 */
public class Lc448 {
    /**
     * Hash法
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] count = new int[n+1];
        for (int num : nums) {
            count[num]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 鸽笼法，原地修改
     * 如果某个数X存在，则修改对应nums[x-1]为其的负数，最后通过遍历数组中的非负数则可以得到答案
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i =0;i<nums.length;i++) {
            //nums[abs(n)-1] = - abs(nums[abs(n)-1])
            int temp = Math.abs(nums[i]);
            //保证转为负数
            nums[temp-1] = -Math.abs(nums[temp-1]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i =0;i<nums.length;i++) {
            if (nums[i] > 0) {
                ans.add(i+1);
            } else {
              //恢复
              nums[i] = -nums[i];
            }
        }
        return ans;
     }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}