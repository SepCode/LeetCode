package _8_高频题;

import Common.Node;

public class _剑指_Offer_36_二叉搜索树与双向链表 {
    Node head = null;
    Node prev = null;
    public Node treeToDoublyList(Node root) {

        if (root == null) return null;
        inorder(root);
        prev.right = head;
        head.left = prev;
        return head;
    }

    public void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);

        if (head == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        inorder(node.right);
    }


    public static void main(String[] args) {
        Node left = new Node(0, null, null);
        Node right = new Node(0, null, null);
        Node root = new Node(0, left, right);

        new _剑指_Offer_36_二叉搜索树与双向链表().treeToDoublyList(root);
    }
}
