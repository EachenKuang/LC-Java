package com.eachenkuang.swordoffer;

/**
 * @author eachenkuang
 * @date 2022/9/21 14:28
 * @description:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1.
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：numbers = [2,2,2,0,1]
 * 输出：0
 *
 */
public class Sword11 {
    /**
     * 暴力法，直接遍历
     *
     * 时间复杂度：O(N)
     */
    public static int minArray(int[] numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < result) {
                result = numbers[i];
            }
        }
        return result;
    }

    /**
     * 二分法
     *
     * 时间复杂度：O(N)，最坏条件下，全是相同的值，那么会退化成O(N)
     * 平均时间复杂度：O(logN)
     * @param numbers
     * @return
     */
    public static int minArray2(int[] numbers) {
        // 区间为闭区间
        int left = 0;
        int right = numbers.length-1;
        while (left <= right) {
            int mid = right - (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] numbers = {3,4,5,1,2};
        System.out.println(minArray(numbers));
        System.out.println(minArray2(numbers));

    }
}
