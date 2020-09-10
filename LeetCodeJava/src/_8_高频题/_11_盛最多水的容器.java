package _8_高频题;

public class _11_盛最多水的容器 {
    public int maxArea(int[] height) {

        if (height == null || height.length == 0) return 0;

        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, h * (j - i));
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
            // 优化
            while (i < j && height[i] <= h) i++;
            while (i < j && height[j] <= h) j--;
            //
        }
        return max;
    }
}
