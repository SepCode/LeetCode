package _6_树;

import Common.TreeNode;

public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        return r1.val == r2.val && check(r1.right, r2.left) && check(r1.left, r2.right);
    }
}
