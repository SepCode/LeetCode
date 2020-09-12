package _8_高频题;

import java.util.PriorityQueue;
import java.util.Queue;

public class _剑指_Offer_40_最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k == 0) return new int[0];

        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                queue.add(arr[i]);
            } else if(arr[i] < queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }

        int[] nums = new int[k];
        int idx = 0;
        for (int num:
             queue) {
            nums[idx++] = num;
        }
        return nums;
    }
}
