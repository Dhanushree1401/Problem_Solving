class Solution {
    private int[][] dp;
    private int sol(int[][] f, int i, int j, String[] v, String t) 
    {
        if (i >= t.length())
            return 1; 
        if (j >= f.length)
            return 0; 
        if (dp[i][j] != -1)
            return dp[i][j];
        long ans = 0;
        ans = sol(f, i, j + 1, v, t) % (long)(1e9+7);
        long tmp = f[j][t.charAt(i) - 'a'];
        if (tmp > 0)
            ans = (ans + (sol(f, i + 1, j + 1, v, t) * tmp) % (long)(1e9+7)) % (long)(1e9+7);
        dp[i][j] = (int)(ans%(long)(1e9+7));
        return dp[i][j];
    }
    public int numWays(String[] v, String t) 
    {
        int n = t.length();
        int m = v[0].length();
        dp = new int[n + 1][m + 1];
        for (int[] r : dp) 
            Arrays.fill(r, -1);
        int[][] f = new int[m][26];
        for (int j = 0; j < m; j++) 
        {
            for (String s : v)
                f[j][s.charAt(j) - 'a']++;
        }
        return sol(f, 0, 0, v, t);
    }
}