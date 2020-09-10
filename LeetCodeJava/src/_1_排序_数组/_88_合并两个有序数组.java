package _1_排序_数组;

public class _88_合并两个有序数组 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {

//		输入:
//			nums1 = [1,2,3,0,0,0], m = 3
//			nums2 = [2,5,6],       n = 3
//
//		输出: [1,2,2,3,5,6]
		
		// 冲右往左比较，大的放cur
		// nums1大：cur--，m--
		// nums2大：cur--，n--
		// n小于0时结束，m小于0时，剩余nums2复制到nums1
		int cur = nums1.length - 1;
		m--;
		n--;
		while (n >= 0) {
			if ( m >= 0 && nums2[n] < nums1[m]) {
				nums1[cur--] = nums1[m--];
			} else {
				nums1[cur--] = nums2[n--];
			}
		}
		

		
    }
}
