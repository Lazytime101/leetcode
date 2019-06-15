package src.longestPalindrome_5;

public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }


    public String longestPalindrome1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                dp[j][i] = (j+1 > i-1 || dp[j+1][i-1]) && s.charAt(j) == s.charAt(i);
                if (dp[j][i] && res.length() < i - j + 1){
                    res = s.substring(j, i+1);
                }
            }
        }
        return res;
    }
}
