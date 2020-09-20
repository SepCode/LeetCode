package _5_动态规划;

import java.util.ArrayList;

public class _面试题_字节跳动_查找K数 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] nums = new int[]{1,3,2,4,7,5,9,10,8,12,13};
        ArrayList<Integer> list = new _面试题_字节跳动_查找K数().findK(nums);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


        System.out.println("Hello World!");
    }

    public ArrayList<Integer> findK(int[] nums){
        if(nums == null || nums.length == 0) return new ArrayList<>();
        int len = nums.length;
        int[] dp = new int[len];
        dp[len - 1] = nums[len - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            dp[i] = Math.min(dp[i + 1], nums[i]);
        }
        int l = 0;
        ArrayList<Integer> list = new ArrayList<>();
        if(nums[l] <= dp[l]) {
            list.add(nums[l]);
        }
        for(int i = 1; i < len; i++){
            if(nums[l] < nums[i]){
                l = i;
                if(nums[i] <= dp[i]) {
                    list.add(nums[i]);
                }
            }
        }

        return list;
    }
}
