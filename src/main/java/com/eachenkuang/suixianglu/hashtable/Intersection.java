package com.eachenkuang.suixianglu.hashtable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author eachenkuang
 * @date 2022/8/22 9:50 AM
 * @description:
 */
public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> ansSet = new HashSet<>();
        for (int j : nums1) {
            set1.add(j);
        }
        for (int j : nums2) {
            if (set1.contains(j)) {
                ansSet.add(j);
            }
        }
        return ansSet.stream().mapToInt(x->x).toArray();
    }

}
