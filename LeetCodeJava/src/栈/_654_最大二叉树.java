package 栈;

import Common.TreeNode;

public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
//    	输入：[3,2,1,6,0,5]
//		输出：返回下面这棵树的根节点：
//
//		      6
//		    /   \
//		   3     5
//		    \    / 
//		     2  0   
//		      \
//		       1
    	
    	// 递归
    	
    	if (nums == null) {
			return null;
		}
    	
    	return findMaxNode(nums, 0, nums.length);
    	
    	
    	

    }
    // [l,r)
    private TreeNode findMaxNode(int[] nums, int l, int r) {
		
    	if (l == r) {
			return null;
		}
    	
    	int maxIdx = l;
    	for (int i = l + 1; i < r; i++) {
			if (nums[i] > nums[maxIdx]) {
				maxIdx = i;
			}
		}
    	
    	TreeNode node = new TreeNode(nums[maxIdx]);
    	node.left = findMaxNode(nums, l, maxIdx);
    	node.right = findMaxNode(nums, maxIdx + 1, r);
    	
    	return node;
    	
	}
    	
    	
    	
    	
    	
    	
    	
    	

    	
    	// 栈
//    	  				[3,2,1,6,0,5]
//    	  				
//    	  |      |
//    	  |		 |
//    	  |	 1   |
//    	  |	 2   |
//    	  |  3   |
//    	  |------|
//    	  
//    	 */
//    	int len = nums.length;
//    	if (nums == null || len == 0) return null;
//    	if (len == 1) {
//			return new TreeNode(nums[0]);
//		}
//
//    	LinkedList<Integer> stack = new LinkedList<>();
//    	int[] lis = new int[len];
//    	int[] ris = new int[len];
//    	TreeNode[] trees = new TreeNode[len];
//    	
//    	for (int i = 0; i < len; i++) {
//			lis[i] = -1;
//			ris[i] = -1;
//			trees[i] = new TreeNode(nums[i]);
//		}
//
//    	for (int i = 0; i < len; i++) {
//    		
//			while (!stack.isEmpty() && nums[i] > nums[stack.getLast()]) {
//				int tmp = stack.removeLast();
//				ris[tmp] = i;
//			}
//			if (!stack.isEmpty()) {
//				lis[i] = stack.getLast();
//			}
//			stack.addLast(i);;
//		}
//    	
//    	TreeNode root = null;
//    	for (int i = 0; i < len; i++) {
//			if (lis[i] == -1 && ris[i] == -1) {
//				root = trees[i];
//			} else if (lis[i] == -1) {
//				trees[ris[i]].left = trees[i];
//			} else if (ris[i] == -1) {
//				trees[lis[i]].right = trees[i];
//			} else if (nums[lis[i]] < nums[ris[i]]) {
//				trees[lis[i]].right = trees[i];
//			} else {
//				trees[ris[i]].left = trees[i];
//			}
//		}
//    	
//    	return root;

}
