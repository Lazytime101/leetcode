/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while(x!=0){
            int temp = x%10;
            x=x/10;
            //总体result check
            if(result>Integer.MAX_VALUE/10||result<Integer.MIN_VALUE/10){
                return 0;
            } 
            if(result==Integer.MAX_VALUE/10&&temp>7)
            return 0;
            if(result==Integer.MIN_VALUE/10&&temp<-8)
            return 0;
            result = 10*result+temp;
        
        }

        return result;
    }

   

}



// @lc code=end

