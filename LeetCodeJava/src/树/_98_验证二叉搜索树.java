package 树;

import Common.TreeNode;

public class _98_验证二叉搜索树 {
    TreeNode prev;
    boolean isB = true;
    public boolean isValidBST(TreeNode root) {

        inorder(root);
        return isB;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            isB = false;
            return;
        }
        prev = root;
        inorder(root.right);
    }
}
