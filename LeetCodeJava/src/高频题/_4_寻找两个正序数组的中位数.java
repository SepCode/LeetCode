package 高频题;

public class _4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;;
        int len2 = nums2.length;
        int mid1 = (len1 + len2 + 1) >> 1; //   偶数的话为左边中位数，奇数的话为中位数自己
        int mid2 = (len1 + len2 + 2) >> 1; //   偶数的话为右边中位数，奇数的话为中位数自己
        return (findM(nums1, nums2, 0, 0, mid1) + findM(nums1, nums2, 0, 0, mid2)) / 2;
    }

    private double findM(int[] num1, int[] num2, int i, int j, int mid) {

        // 1 i大于num1
        // 2 j大于num2
        if (i >= num1.length) return num2[j + mid - 1];
        if (j >= num2.length) return num1[i + mid - 1];

        // 3 二分查找mid最小为1
        if (mid == 1) return Math.min(num1[i], num2[j]);

        // 4 查找mid/2
        int halfMid = mid >> 1;
        int v1 = i + halfMid <= num1.length ? num1[i + halfMid - 1] : Integer.MAX_VALUE;
        int v2 = j + halfMid <= num2.length ? num2[j + halfMid - 1] : Integer.MAX_VALUE;

        // 5 递归查找
        if (v1 < v2) {
            return findM(num1, num2, i + halfMid, j, mid - halfMid);
        } else {
            return findM(num1, num2, i, j + halfMid, mid - halfMid);
        }

    }

}
