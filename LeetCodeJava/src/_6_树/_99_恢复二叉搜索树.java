package _6_树;

import Common.TreeNode;

public class _99_恢复二叉搜索树 {
    TreeNode first;
    TreeNode second;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {

        findNode(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

    }

    private void findNode(TreeNode node) {
        if (node == null) return;
        findNode(node.left);
        if (prev.val > node.val) {
            second = node;
            if (first == null) {
                first = prev;
            } else {
                return;
            }
        }
        prev = node;
        findNode(node.right);
    }

}
