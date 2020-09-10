package _1_排序_数组;

public class _面试题_16_16_部分排序 {
	public int[] subSort(int[] array) {

//		输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
//		输出： [3,9]
		
		// 正向：最大逆序的位置
		if (array.length == 0) {
			return new int[]{-1, -1};
		}
		int l = -1;
		int max = array[0];
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] < max) {
				l = i;
			} else {
				max = array[i];				
			}
		}
		
		if (l == -1) {
			return new int[]{-1, -1};
		}
		
		
		
		int r = -1;
		int min = array[array.length - 1];
		
		for (int i = array.length - 2; i >= 0 ; i--) {
			if (array[i] > min) {
				r = i;
			} else {
				min = array[i];				
			}
		}
		
		return new int[]{r,l};
    }
}
