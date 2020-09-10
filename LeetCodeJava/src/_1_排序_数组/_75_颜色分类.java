package _1_排序_数组;

public class _75_颜色分类 {
	public void sortColors(int[] nums) {

//		输入: [2,0,2,1,1,0]
//		输出: [0,0,1,1,2,2]
		// 需要三个指针
		// l指向左面可用位置，r指向右面可用位置
		int l = 0, i = 0;
		int r = nums.length - 1;
		
		while (i <= r) {
			if (nums[i] > 1) {
				swap(nums, i, r--);
			} else if (nums[i] < 1){
				swap(nums, i++, l++);
			} else {
				i++;
			}
		}
		
    }
	
	void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
