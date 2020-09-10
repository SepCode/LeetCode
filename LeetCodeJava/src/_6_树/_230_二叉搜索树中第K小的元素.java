package _6_树;

import Common.TreeNode;

public class _230_二叉搜索树中第K小的元素 {
    int pk;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        pk = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        pk--;
        if (pk == 0) {
            result = root.val;
            return;
        }
        inorder(root.right);
    }
}
