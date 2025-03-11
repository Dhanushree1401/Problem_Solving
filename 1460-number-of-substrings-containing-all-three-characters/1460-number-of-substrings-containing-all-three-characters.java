class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), ans = 0;
        int[] hash = new int[3]; 
        int i = 0, j = 0; 

        for (; j < n; j++) { 
            char ch = s.charAt(j);
            hash[ch - 'a']++; 
            while (valid(hash)) { 
                ans += (n - j); 

                ch = s.charAt(i);
                hash[ch - 'a']--; 
                i++; 
            }
        }
        return ans; 
    }

    private boolean valid(int[] hash) {
        return hash[0] > 0 && hash[1] > 0 && hash[2] > 0;
    }
}