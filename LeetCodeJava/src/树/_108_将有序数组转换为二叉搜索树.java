package 树;

import Common.TreeNode;

public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return rootNode(nums, 0, nums.length);

    }

    private TreeNode rootNode(int[] nums, int l, int r) {
        if (l >= r) return null;

        int mid = (l + r) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = rootNode(nums, l, mid);
        root.right = rootNode(nums, mid + 1, r);
        return root;
    }
}
