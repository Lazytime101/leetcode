package src.maxSubArray_53;

/**
 * @author lazytime
 * 异常情况考虑太少
 * 初始化至少带上第一个
 * 对于负值思考太少
 */
public class Solution {
    /**
     * @param nums
     * @return
     * dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
     * 递归表达式
     */
    public int maxSubArray2(int[] nums) {
        if(nums.length==0||nums==null){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        //dp[i] means the maximum subarray ending with nums[i];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * @param nums
     * @return
     * 效率高，还不是很理解
     */
    public int maxSubArray3(int[] nums) {

        int sum = 0;
        int maxsum = Integer.MIN_VALUE;
        if(nums.length==0||nums==null){
            return 0;
        }

        for(int i = 0; i < nums.length; i++)
        {
            sum = sum + nums[i];

            if(sum > maxsum)
                maxsum = sum;

            if(sum < 0)
                sum = 0;

        }
        return maxsum;
    }

}
