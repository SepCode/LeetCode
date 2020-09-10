package _4_字符串;

import Common.TreeNode;

public class _572_另一个树的子树 {

	int count = 0;
	boolean check = false;
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null || t == null) {
			return false;
		}
		count = calcCount(t);
		dfs(s, t);
		return  check;
	}

	private int calcCount(TreeNode node) {
		if (node == null) return 0;
		return calcCount(node.left) + calcCount(node.right) + 1;
	}


	private int dfs(TreeNode s, TreeNode t) {

		if (s == null || check) return 0;

		int c = dfs(s.left, t) + dfs(s.right, t) + 1;
		if (c == count && check(s, t)) {
			check = true;
			return 0;
		}

		return c;
	}

	private boolean check(TreeNode s, TreeNode t) {

		if (s == null && t == null) return true;
		if (s == null || t == null) return false;
		if (s.val != t.val) return false;

		return check(s.left, t.left) && check(s.right, t.right);

	}


//	public boolean isSubtree(TreeNode s, TreeNode t) {
//		if (s == null || t == null) {
//			return false;
//		}
//        String sStr = postSequence(new StringBuilder(), s);
//        String tStr = postSequence(new StringBuilder(), t);
//        return sStr.contains(tStr);
//    }
//
//	private String postSequence(StringBuilder sb, TreeNode node) {
//
//		if (node.left == null) {
//			sb.append("#!");
//		} else {
//			postSequence(sb, node.left);
//		}
//		if (node.right ==null) {
//			sb.append("#!");
//		} else {
//			postSequence(sb, node.right);
//		}
//
//		sb.append(node.val).append("!");
//		return sb.toString();
//	}
}
