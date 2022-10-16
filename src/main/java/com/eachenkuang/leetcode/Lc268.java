package com.eachenkuang.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

 

示例 1：

输入：nums = [3,0,1]
输出：2
解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
示例 2：

输入：nums = [0,1]
输出：2
解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
示例 3：

输入：nums = [9,6,4,2,3,5,7,0,1]
输出：8
解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
示例 4：

输入：nums = [0]
输出：1
解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。

*/
public class Lc268 {

    /**
     * 排序法
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 哈希法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 先遍历所有数，加到集合中
     * 然后根据0-n遍历，看哪个不在
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int missing = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;
    }
    
    /**
     * 位运算
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 将n个数以及0-n总共2n-1个数，做一次异或运算，最后剩下的就是丢失的数，只出现一次的数。
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }

    /**
     * 数学法
     * 先计算0-n的总和，然后减去所有的数的和，剩余的就是不存在的那个数
     * @param nums
     * @return
     */
    public static int missingNumber4(int[] nums) {
        int length = nums.length;
        int expectedSum = length * (length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5};
        System.out.println(missingNumber(nums));
    }
}
