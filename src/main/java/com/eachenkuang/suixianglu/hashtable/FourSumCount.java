package com.eachenkuang.suixianglu.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eachenkuang
 * @date 2022/8/22 10:22 AM
 * @description:
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
 *
 * 例如:
 *
 * 输入:
 *
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 输出:
 *
 * 2
 */
public class FourSumCount {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 用来保存 nums1 与 nums2 中的两数组合的和以及对应和的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums1) {
            for (int m: nums2) {
                int sum = m+n;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum)+1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        int count = 0;
        for (int n: nums3) {
            for (int m: nums4) {
                int sum = m+n;
                if (map.containsKey(-sum)) {
                    count+= map.get(-sum);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1,2,2};
        int[] B = {-2,-1};
        int[] C= {-1, 2};
        int[] D = { 0, 2};
        System.out.print(fourSumCount(A,B,C,D));

    }
}
