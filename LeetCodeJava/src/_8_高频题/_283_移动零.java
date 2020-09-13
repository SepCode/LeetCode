package _8_高频题;

public class _283_移动零 {
    public void moveZeroes(int[] nums) {

        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, cur++, i);
            }
        }
    }

    private void swap(int[] nums, int cur, int i) {
        if (cur == i) return;
        int tmp = nums[cur];
        nums[cur] = nums[i];
        nums[i] = tmp;
    }

}
