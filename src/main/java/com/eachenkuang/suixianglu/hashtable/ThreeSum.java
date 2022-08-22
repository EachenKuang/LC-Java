package com.eachenkuang.suixianglu.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author eachenkuang
 * @date 2022/8/22 10:54 AM
 * @description:
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    /**
     * 正常来说，对于三数之和，我们如果直接使用暴力法，需要的 N^3 时间复杂度，而且还要考虑重复的情况。
     * 那么这题的目标实际上是如何进行去重。
     * 我们首先进行排序
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // 需要先排序一次
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // 如果最小的数也大于0，则肯定没有解
                return result;
            }
            if (i>0 && nums[i] == nums[i-1]) {
                // 对 a（第一个数产生的结果集） 进行去重
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[left] == nums[left+1]) left++;
                    while (right > left && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
