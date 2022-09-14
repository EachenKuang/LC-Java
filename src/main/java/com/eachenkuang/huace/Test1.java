package com.eachenkuang.huace;

/**
 * @author eachenkuang
 * @date 2022/9/6 15:16
 * @description:
 * Int[] a = {1, 3, 5, 70}
 * Int[] b = {20, 40, 60, 80}
 *
 * //给定两个排好序的数组
 * Int findK(int[] a, int[] b, int K) {
 * // 返回两个数组第K小的值
 * }
 * k 正数，合理的值
 */
public class Test1 {
    /**
     *
     * @param a
     * @param b
     * @param k
     * @return
     */
    public static int findK(int[] a, int[] b, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        int pre = Integer.MAX_VALUE;
        while (left < a.length && right < b.length) {
            if (a[left] <= b[right]) {
                pre = a[left];
                left++;
            } else {
                right++;
                pre = b[right];
            }
            count++;
            if (count == k) {
                return pre;
            }
        }
        while (left < a.length) {
            pre = a[left];
            left++;
            count++;
            if (count==k) {
                return pre;
            }
        }
        while (right < b.length) {
            pre = b[right];
            right++;
            count++;
            if (count==k) {
                return pre;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 70};
        int[] b = {20, 40, 60, 80};
        System.out.print(findK(a, b, 3));
    }

}
