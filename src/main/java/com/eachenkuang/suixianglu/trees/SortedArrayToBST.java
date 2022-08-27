package com.eachenkuang.suixianglu.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBST {
    /**
     * 
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversel(nums, 0, nums.length - 1);
    }

    /**
     * 前闭后闭
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode traversel(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = right - (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversel(nums, left, mid - 1);
        root.right = traversel(nums, mid + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST2(int[] nums) {
		if (nums.length == 0) return null;

		//根节点初始化
		TreeNode root = new TreeNode(-1);
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Queue<Integer> leftQueue = new LinkedList<>();
		Queue<Integer> rightQueue = new LinkedList<>();

		// 根节点入队列
		nodeQueue.offer(root);
		// 0为左区间下标初始位置
		leftQueue.offer(0);
		// nums.size() - 1为右区间下标初始位置
		rightQueue.offer(nums.length - 1);

		while (!nodeQueue.isEmpty()) {
			TreeNode currNode = nodeQueue.poll();
			int left = leftQueue.poll();
			int right = rightQueue.poll();
			int mid = left + ((right - left) >> 1);

			// 将mid对应的元素给中间节点
			currNode.val = nums[mid];

			// 处理左区间
			if (left <= mid - 1) {
				currNode.left = new TreeNode(-1);
				nodeQueue.offer(currNode.left);
				leftQueue.offer(left);
				rightQueue.offer(mid - 1);
			}

			// 处理右区间
			if (right >= mid + 1) {
				currNode.right = new TreeNode(-1);
				nodeQueue.offer(currNode.right);
				leftQueue.offer(mid + 1);
				rightQueue.offer(right);
			}
		}
		return root;
	}
}
