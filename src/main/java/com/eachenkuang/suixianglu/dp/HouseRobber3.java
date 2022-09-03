package com.eachenkuang.suixianglu.dp;

import com.eachenkuang.suixianglu.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author eachenkuang
 * @date 2022/9/3 21:43
 * @description:
 */
public class HouseRobber3 {
    /**
     * 暴力递归
     * 后序遍历
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        // 解决一些边界情况
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        // 偷父节点
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        // 不偷父节点
        int val2 = rob(root.left) + rob(root.right);
        return Math.max(val1, val2);
    }



    /**
     * memory + 递归
     * @param root
     * @return
     * 时间复杂度：O(N)
     */
    // 使用一个map存储节点对应的最大值
    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob2(TreeNode root) {
        // 解决一些边界情况
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (map.containsKey(root)) {
            // 如果保存了直接返回
            return map.get(root);
        }
        // 偷父节点
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        // 不偷父节点
        int val2 = rob(root.left) + rob(root.right);
        int result = Math.max(val1, val2);
        // 返回前记录下当前节点的结果
        map.put(root, result);
        return result;
    }

    public int rob3(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    int[] robAction1(TreeNode root) {
        int res[] = new int[2];
        if (root == null)
            return res;

        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
    }
}
