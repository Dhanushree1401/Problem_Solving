class Solution {
    public int longestPalindrome(String s) {
        int[] charCounts = new int[128];
        for (char ch : s.toCharArray()) {
            charCounts[ch]++;
        }
        int length = 0;
        boolean countexit = false;
        for (int count : charCounts) {
            length += count / 2 * 2; 
            if (count % 2 == 1) 
            {
                countexit = true;
            }
        }
        if (countexit) {
            length++;
        }
        return length;
    }
}
