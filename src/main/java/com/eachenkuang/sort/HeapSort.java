package com.eachenkuang.sort;

/**
 * @author eachenkuang
 * @date 2022/8/19 7:21 PM
 * @description:
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {3,5,16,4,0};
        for (int num: heapSort(nums)) {
            System.out.println(num);
        }
    }

    private static int[] heapSort(int[] nums) {
        int heapLen = nums.length;
        buildMaxHeap(nums, heapLen);

        for (int i = 0; i < nums.length; i++) {
            // 先交换，然后长度减一，重新调整新的堆顶
            Tool.swap(nums, heapLen-1, 0);
            heapLen--;
            heapify(nums, 0, heapLen);
        }
        return nums;
    }

    private static void buildMaxHeap(int[] nums, int heapLen) {
        for (int i = nums.length/2 - 1; i >= 0; i--) {
            heapify(nums, i, heapLen);
        }
    }

    private static void heapify(int[] nums, int i, int heapLen) {
        int largest = i;
        int left = i * 2 +1;
        int right = i*2+2;
        if (left < heapLen && nums[largest] < nums[left]) {
            largest = left;
        }
        if (right < heapLen && nums[largest] < nums[right]) {
            largest = right;
        }
        if (largest != i) {
            Tool.swap(nums, largest, i);
            // 递归调整子节点
            heapify(nums, largest, heapLen);
        }

    }
}
