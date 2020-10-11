package _8_高频题;

public class _31_下一个排列 {
    public void nextPermutation(int[] nums) {

        // 找到最后的升序对
        // 找到最后一个比升序对前值大的值
        int l = nums.length - 2;
        while (l >= 0 && nums[l] > nums[l + 1]) {
            l--;
        }

        if (l >= 0) {
            int r = nums.length - 1;
            while (r > l && nums[l] > nums[r]) {
                r--;
            }
            swap(nums, l , r);

        }

        for (int i = l + 1, j = nums.length - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }


    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[r];
        nums[r] = nums[l];
        nums[l] = tmp;
    }


}
