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

        // 3










    }

}
