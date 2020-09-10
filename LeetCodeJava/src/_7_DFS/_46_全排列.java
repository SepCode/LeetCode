package _7_DFS;

import java.util.ArrayList;
import java.util.List;

public class _46_全排列 {

    List<List<Integer>> result = new ArrayList<>();
    int[] list;
    int[] numbs;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        numbs = nums;
        list = new int[nums.length];
        used = new boolean[nums.length];
        dfs(0);
        return result;
    }

    private void dfs(Integer idx) {
        if (idx == list.length) {
            List<Integer> subResult = new ArrayList<>();
            for (int r : list) {
                subResult.add(r);
            }
            result.add(subResult);
            return;
        }

        for (int i = 0; i < numbs.length; i++) {
            if (used[i]) continue;
            list[idx] = numbs[i];
            used[i] = true;
            dfs(idx + 1);
            used[i] = false;
        }
    }


}
