package _6_树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        nodeList.add(root);
        while (!nodeList.isEmpty()) {
            int size = nodeList.size();
            List<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode node = nodeList.removeFirst();
                sublist.add(node.val);
                if (node.left != null) nodeList.add(node.left);
                if (node.right != null) nodeList.add(node.right);
            }
            list.add(sublist);
        }
        return list;
    }
}
