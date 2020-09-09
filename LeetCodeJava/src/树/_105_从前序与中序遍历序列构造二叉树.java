package 树;

import Common.TreeNode;

import java.util.HashMap;

public class _105_从前序与中序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

//        preorder = [3,9,20,15,7]
//        inorder = [9,3,15,20,7]


        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    private TreeNode buildTree(HashMap<Integer, Integer> map, int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl >= pr || il >= ir) return null;

        int root = preorder[pl];
        int iroot = map.get(root);
        int offset = iroot - il;
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = buildTree(map, preorder, inorder, pl + 1, pl + offset + 1, il, iroot);
        rootNode.right = buildTree(map, preorder, inorder, pl + offset + 1, pr, iroot + 1, ir);
        return rootNode;
    }
}
