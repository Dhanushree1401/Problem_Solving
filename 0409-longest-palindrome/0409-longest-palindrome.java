class Solution {
    public int longestPalindrome(String s) {
        int[] charCounts = new int[128];
        for (char ch : s.toCharArray()) {
            charCounts[ch]++;
        }

        int length = 0;
        boolean oddCountExists = false;
        for (int count : charCounts) {
            length += count / 2 * 2; 
            if (count % 2 == 1) {
                oddCountExists = true; 
            }
        }
        if (oddCountExists) {
            length++;
        }

        return length;
    }
}
