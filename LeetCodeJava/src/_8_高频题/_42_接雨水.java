package _8_高频题;

public class _42_接雨水 {

    public int trap(int[] height) {

        //
        //
        //
        //      |                           |
        //      |      |      |      |      |
        //      |      |      |      |      |      |


        if (height == null || height.length == 0) return 0;
        int sum = 0;
        int i = 0, j = height.length - 1;
        int lowerMax = 0;

        while (i < j) {
            int lowerIndex = height[i] > height[j] ? j-- : i++;
            int lower = height[lowerIndex];

            lowerMax = Math.max(lowerMax, lower);

            sum += (lowerMax - lower);

        }

        return sum;
    }


    public int trap1(int[] height) {

        //
        //
        //
        //      |                           |
        //      |      |      |      |      |
        //      |      |      |      |      |      |


        if (height == null || height.length == 0) return 0;
        int sum = 0;
        int leftMax = height[0], rightMax = height[height.length - 1];
        for (int i = 0, j = height.length - 1; i < j;) {
            if (leftMax > rightMax) {
                sum += (rightMax - height[j]);
                j--;
                rightMax = Math.max(rightMax, height[j]);
            } else {
                sum += (leftMax - height[i]);
                i++;
                leftMax = Math.max(leftMax, height[i]);
            }

        }


        return sum;
    }
}
