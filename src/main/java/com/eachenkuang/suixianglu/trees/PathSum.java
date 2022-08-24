package com.eachenkuang.suixianglu.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author eachenkuang
 * @date 2022/8/24 11:53 AM
 * @description:
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 */
public class PathSum {
    /**
     * 回溯法
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> paths = new LinkedList<>();
        if (root == null) {
            return results;
        }
        backTracing(root, results, paths, targetSum-root.val);
        return results;
    }

    public void backTracing(TreeNode root, List<List<Integer>> results, LinkedList<Integer> paths, int target) {
        paths.addLast(root.val);
        if (root.left == null && root.right == null && target == 0) {
            // 遇到叶子节点，且满足条件，需要拷贝当前数组形成一个新的数组
            List<Integer> newPaths = new ArrayList<>(paths);
            results.add(newPaths);
            return;
        }
        if (root.left != null) {
            backTracing(root.left, results, paths, target-root.left.val);
            paths.removeLast(); // 回溯
        }
        if (root.right != null) {
            backTracing(root.right, results, paths,target-root.right.val);
            paths.removeLast(); // 回溯
        }
    }
}
