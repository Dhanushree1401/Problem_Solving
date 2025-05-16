class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length(), m = n;
        int[][][][] dp = new int[n][n][n][n];

        for(int[][][] it : dp){
            for(int[][] ele : it){
                for(int[] res : ele){
                    Arrays.fill(res, -1);
                }
            }
        }

        return f(s1, s2, 0, n-1, 0, m-1, dp);
    }

    private boolean f(String s1, String s2, int i1, int j1, int i2, int j2, int[][][][] dp){
        if(i1 > j1){
            return false;
        }

        if(i1 == j1){
            return s1.charAt(i1) == s2.charAt(i2);
        }

        if(dp[i1][j1][i2][j2] != -1){
            return dp[i1][j1][i2][j2] == 1;
        } 

        int n = j1 - i1;

        for(int k = 0;k < n;k++){
            if(f(s1, s2, i1, i1+k, i2, i2+k, dp) && f(s1, s2, i1+k+1, j1, i2+k+1, j2, dp)){
                dp[i1][j1][i2][j2] = 1;
                return true;
            }

            if(f(s1, s2, i1, i1+k, j2-k, j2, dp) && f(s1, s2, i1+k+1, j1, i2, j2-k-1, dp)){
                dp[i1][j1][i2][j2] = 1;
                return true;
            }
        }

        dp[i1][j1][i2][j2] = 0;

        return false;
    }
}