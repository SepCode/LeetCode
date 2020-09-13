package _8_高频题;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _面试题_17_14_最小K个数 {
    public int[] smallestK(int[] arr, int k) {
        if(arr == null || k == 0) return new int[0];
        if (arr.length <= k) return arr;

        partition(arr, 0, arr.length - 1, k);

        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }

    private void partition(int[] arr, int left, int right, int k) {

        if (left >= right) return;
        int l = left;
        int r = right;

        int p = arr[l];
        while (l < r) {
            while (l < r && p <= arr[r]) r--;
            arr[l] = arr[r];
            while (l < r && p >= arr[l]) l++;
            arr[r] = arr[l];
        }
        arr[l] = p;

        if (l == k) {
            return;
        } else if (l > k) {
            partition(arr, left, l - 1, k);
        } else {
            partition(arr, l + 1, right, k);
        }

    }


    public int[] smallestK1(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k == 0) return new int[0];

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }
        for(int i = k; i < arr.length; i++) {
            if(arr[i] > queue.peek()) {
                queue.poll();
                queue.add(arr[i]);
            }
        }
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = queue.poll();
        }
        return nums;

    }

    public static void main(String[] args) {
        System.out.println(new _面试题_17_14_最小K个数().smallestK(new int[]{0,1,2,1}, 1));;
    }
}
