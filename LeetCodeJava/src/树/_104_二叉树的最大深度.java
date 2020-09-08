package 树;

import Common.TreeNode;

public class _104_二叉树的最大深度 {
    // 递归
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    // 层序遍历有多少层
}
