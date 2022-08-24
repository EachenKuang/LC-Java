package com.eachenkuang.suixianglu.trees;

/**
 * @author eachenkuang
 * @date 2022/8/24 6:46 PM
 * @description:
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 *
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructMaximumBinaryTree {
    /**
     * 使用递归方法
     * 步骤：
     * 1、找到最大的那个数，作为根节点，左边的数是用于左子树，右边的数用于右子树
     * 2、分别递归执行左右子树的步骤1
     *
     * 时间复杂度：O(n^2)  在最坏的情况下，数组严格递增或递减，需要递归 nn 层
     * 空间复杂度：O(n)，即为最坏情况下需要使用的栈空间。树变成链表的情况
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return findTreeNode(nums, 0, nums.length);
    }

    public TreeNode findTreeNode(int[] nums, int start, int end) {
        if (start >= end) {
            return null;
        }
        int maxIndex = findMaxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = findTreeNode(nums, start, maxIndex);
        root.right = findTreeNode(nums, maxIndex+1, end);
        return root;
    }

    public int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
