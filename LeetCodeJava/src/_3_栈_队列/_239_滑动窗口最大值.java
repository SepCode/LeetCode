package _3_栈_队列;

import java.util.LinkedList;

public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
//    	输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//		输出: [3,3,5,5,6,7] 
//		解释: 
//
//		  滑动窗口的位置                最大值
//    	
//    	 l      r
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

		// 双端队列
    	LinkedList<Integer> queue = new LinkedList<>();
    	int[] maxs = new int[nums.length - k + 1];

    	for (int r = 0; r < nums.length; r++) {
			int l = r - k + 1;

			if (queue.isEmpty()) {
				queue.addLast(r);
			} else if (queue.getFirst() < l) {
				queue.removeFirst();
			}

			while (!queue.isEmpty() && nums[r] >= nums[queue.getLast()]) {
				queue.removeLast();
			}
			queue.addLast(r);
			if (l >= 0) {
				maxs[l] = nums[queue.getFirst()];
			}
		}

    	return maxs;

	}

	public int[] maxSlidingWindow1(int[] nums, int k) {
    	
    	// 优化暴力
    	
    	int maxR = nums.length - k + 1;
    	int[] maxs = new int[maxR];
    	int maxIdx = -1;
    	
    	
    	for (int l = 0; l < maxR; l++) {
			int r = l + k - 1;
			
			if (maxIdx < l) {
				maxIdx = l;
				for (int i = l + 1; i <= r; i++) {
					if (nums[maxIdx] <= nums[i]) {
						maxIdx = i;
					}
				}
			} else if (nums[r] >= nums[maxIdx]) {
				maxIdx = r;
			}
			
			maxs[l] = nums[maxIdx];
		}
    	
    	return maxs;


    }
}
