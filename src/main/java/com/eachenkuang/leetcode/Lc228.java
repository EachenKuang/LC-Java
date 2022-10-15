package com.eachenkuang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个  无重复元素 的 有序 整数数组 nums 。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

"a->b" ，如果 a != b
"a" ，如果 a == b
 */
public class Lc228 {
    public static List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<String> result = new ArrayList<>();
        int pre = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - end == 1) {
                end = nums[i];
            } else {
                if (pre == end) {
                    result.add(String.valueOf(pre));
                } else {
                    result.add(pre + "->" + end);
                }
                pre = nums[i];
                end = nums[i];
            }
        }
        if (pre == end) {
            result.add(String.valueOf(pre));
        } else {
            result.add(pre + "->" + end);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,9,10,100};
        System.out.println(summaryRanges(nums));
    }
}
