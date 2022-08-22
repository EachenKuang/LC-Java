package com.eachenkuang.suixianglu.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eachenkuang
 * @date 2022/8/22 10:13 AM
 * @description:
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length == 0){
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }
            map.put(i, target-nums[i]);
        }
        return result;
    }
}
