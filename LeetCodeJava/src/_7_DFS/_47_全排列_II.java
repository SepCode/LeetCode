package _7_DFS;

import java.util.ArrayList;
import java.util.List;


public class _47_全排列_II {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, 0, list);
        return list;
    }

    private void dfs(int[] nums, int idx, List<List<Integer>> list) {
        if (idx == nums.length) {
            List<Integer> subList = new ArrayList<>();
            for (int i :
                    nums) {
                subList.add(i);
            }
            list.add(subList);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (isRepeat(nums, idx, i)) continue;
            swap(nums, idx, i);
            dfs(nums, idx + 1, list);
            swap(nums, idx, i);
        }
    }

    private void swap(int[] nums, int idx, int i) {
        int tmp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = tmp;
    }

    private boolean isRepeat(int[] nums, int idx, int i) {
        for (int j = idx; j < i; j++) {
            if (nums[j] == nums[i]) return true;
        }
        return false;
    }
}
