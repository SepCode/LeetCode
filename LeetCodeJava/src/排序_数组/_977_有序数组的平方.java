package 排序_数组;

public class _977_有序数组的平方 {
	public int[] sortedSquares(int[] A) {
//		输入：[-7,-3,2,3,11]
//		输出：[4,9,9,49,121]
		
		// 头尾指针比较最大
		
		int l = 0;
		int r = A.length - 1;
		int[] array = new int[A.length];
		int cur = r;
		while (l <= r) {
			int powl = A[l] * A[l];
			int powr = A[r] * A[r];
			if (powl < powr) {
				array[cur--] = powr;
				r--;
			} else {
				array[cur--] = powl;
				l++;
			}
		}
		return array;
    }
}
