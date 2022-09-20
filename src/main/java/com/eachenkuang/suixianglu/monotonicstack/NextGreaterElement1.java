package com.eachenkuang.suixianglu.monotonicstack;

import com.eachenkuang.arrays.Solution;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author eachenkuang
 * @date 2022/9/20 09:43
 * @description:
 * nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
 *
 * 给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 示例 2：
 *
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 *
 */
public class NextGreaterElement1 {

    /**
     * 暴力搜索
     *
     * 时间复杂度 O(mn)
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            int j = 0;
            while (j < n && nums2[j] != nums1[i]) {
                ++j;
            }
            int k = j + 1;
            while (k < n && nums2[k] < nums2[j]) {
                ++k;
            }
            res[i] = k < n ? nums2[k] : -1;
        }
        return res;
    }

    /**
     * 这题还是使用单调栈的方式来完成
     *
     * 时间复杂度 O(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();  // 下标元素，下标
        int[] result = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>(); // 存放元素
        // 初始化
        Arrays.fill(result, -1);
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                if (map.containsKey(nums2[stack.peek()])) {
                    int index = map.get(nums2[stack.peek()]);
                    result[index] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] result = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            System.out.print(" ");
        }
    }
}
