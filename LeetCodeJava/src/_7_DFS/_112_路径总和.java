package _7_DFS;

import Common.TreeNode;

public class _112_路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
