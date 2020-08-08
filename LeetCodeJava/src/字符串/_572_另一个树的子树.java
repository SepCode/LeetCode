package 字符串;

import Common.TreeNode;

public class _572_另一个树的子树 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null || t == null) {
			return false;
		}
        String sStr = postSequence(new StringBuilder(), s);
        String tStr = postSequence(new StringBuilder(), t);
        return sStr.contains(tStr);
    }
	
	private String postSequence(StringBuilder sb, TreeNode node) {
		
		if (node.left == null) {
			sb.append("#!");
		} else {
			postSequence(sb, node.left);
		}
		if (node.right ==null) {
			sb.append("#!");
		} else {
			postSequence(sb, node.right);
		}

		sb.append(node.val).append("!");
		return sb.toString();
	}
}
