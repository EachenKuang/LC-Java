package com.eachenkuang.suixianglu.trees;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 */
public class LowestCommonAncestorBST {
    /**
     * 递归
     * @param root
     * @param p
     * @param q
     * @return
     * 我们从根节点开始遍历；

        如果当前节点的值大于 pp 和 qq 的值，说明 pp 和 qq 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；

        如果当前节点的值小于 pp 和 qq 的值，说明 pp 和 qq 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；

        如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时，pp 和 qq 要么在当前节点的不同的子树中，要么其中一个就是当前节点。

     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root, p, q);
    }

    public TreeNode traversal(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) {
            return cur;
        }
        if (cur.val > p.val && cur.val > q.val) {
            // 在左子树
            return traversal(cur.left, p, q);
        } else if (cur.val < p.val && cur.val < q.val) {
            // 在右子树
            return traversal(cur.right, p, q);
        } else {
            // 只要两个分布在两边 或者 其中一个节点就是 当前节点，就返回
            return cur;
        }
    }

    /**
     * 迭代法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                // 在左子树
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                // 在右子树
                root = root.right;
            } else {
                // 只要两个分布在两边 或者 其中一个节点就是 当前节点，就返回
                return root;
            }
        }
    }
}
