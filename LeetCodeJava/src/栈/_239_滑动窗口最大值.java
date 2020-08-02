package 栈;

import java.util.LinkedList;

public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
//    	输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//		输出: [3,3,5,5,6,7] 
//		解释: 
//
//		  滑动窗口的位置                最大值
//    	
//    	li      ri
//		---------------               -----
//		[1  3  -1] -3  5  3  6  7       3
//		 1 [3  -1  -3] 5  3  6  7       3
//		 1  3 [-1  -3  5] 3  6  7       5
//		 1  3  -1 [-3  5  3] 6  7       5
//		 1  3  -1  -3 [5  3  6] 7       6
//		 1  3  -1  -3  5 [3  6  7]      7
    	
    	/*
    	  
			    	  -----------------------
			    	  [1,1] [2,3]
			    	  -----------------------
    	 
    	 
    	  */
    	
    	// 优化暴力
    	
    	int maxRi = nums.length - k + 1;
    	int[] maxs = new int[maxRi];
    	int maxIdx = -1;
    	
    	
    	for (int li = 0; li < maxRi; li++) {
			int ri = li + k - 1;
			
			if (maxIdx < li) {
				maxIdx = li;
				for (int i = li + 1; i <= ri; i++) {
					if (nums[maxIdx] <= nums[i]) {
						maxIdx = i;
					}
				}
			} else if (nums[ri] >= nums[maxIdx]) {
				maxIdx = ri;
			}
			
			maxs[li] = nums[maxIdx];
		}
    	
    	return maxs;
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	// 双端队列
//    	LinkedList<Integer> queue = new LinkedList<>();
//    	int maxRi = nums.length - k + 1;
//    	int[] maxs = new int[maxRi];
//    	
//    	for (int ri = 0; ri < nums.length; ri++) {
//			int li = ri - k + 1;
//			
//			if (queue.isEmpty()) {
//				queue.addLast(ri);
//			} else if (queue.getFirst() < li) {
//				queue.removeFirst();
//			}
//
//			while (!queue.isEmpty() && nums[ri] >= nums[queue.getLast()]) {
//				queue.removeLast();
//			}
//			queue.addLast(ri);
//			if (li >= 0) {
//				maxs[li] = nums[queue.getFirst()];
//			}
//		}
//
//    	return maxs;
    }
}
