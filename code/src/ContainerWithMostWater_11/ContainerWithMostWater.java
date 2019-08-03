package src.ContainerWithMostWater_11;

public class ContainerWithMostWater {


    /**
     * 最简单的方法   n^2 方法
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int maxSize = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                //里面的一些if方法可以替换成 Math.max
                int high = height[i] > height[j] ? height[j] : height[i];
                int wide = j - i;
                if (high * wide > maxSize) {
                    maxSize = high * wide;
                }
            }
        return maxSize;
    }


    public int maxArea_improve(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxSize = 0;
        while (left < right) {
            maxSize = Math.max(maxSize, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxSize;
    }

}
