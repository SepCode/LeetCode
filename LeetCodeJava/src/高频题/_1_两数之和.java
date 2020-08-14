package 高频题;

import java.util.HashMap;

public class _1_两数之和 {
	public int[] twoSum(int[] nums, int target) {
        
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int j = target - nums[i];
			if (map.containsKey(j)) {
				return new int[] {map.get(j),i};
			} else {
				map.put(nums[i], i);
			}
		}
		
		return null;
    }
}
