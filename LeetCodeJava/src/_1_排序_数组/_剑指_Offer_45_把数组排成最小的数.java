package _1_排序_数组;

import sun.jvm.hotspot.opto.Compile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _剑指_Offer_45_把数组排成最小的数 {
    public String minNumber(int[] nums) {
        String[] list = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            list[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(list, (a, b)->(a + b).compareTo(b + a));

        StringBuilder sb = new StringBuilder();
        for (String s :
                list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
