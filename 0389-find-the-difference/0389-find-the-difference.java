class Solution {
    public char findTheDifference(String s, String t) {
        int[] dd = new int[26]; 
        for (char ch : s.toCharArray()) {
            dd[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            dd[ch - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (dd[i] < 0) {
                return (char) ('a' + i);
            }
        }

        return ' ';
    }
}