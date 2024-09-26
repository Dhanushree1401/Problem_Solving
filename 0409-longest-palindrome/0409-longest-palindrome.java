class Solution {
    public int longestPalindrome(String s) {
        /*Map<Character, Integer> tt = new HashMap<>();
        for (char ch : s.toCharArray()) {
            tt.put(ch, tt.getOrDefault(ch, 0) + 1);
        }
        int length = 0;
        boolean dd = false;
        for (int count : tt.values()) {
            length += count / 2 * 2; 
            if (count % 2 == 1) {
                dd = true;
            }
        }
        if (dd) {
            length++;
        }
        return length;
    }
}*/
        int[] charCounts=new int[126];
        for (char ch:s.toCharArray()) {
            charCounts[ch]++;
        }
        int length=0;
        boolean countexit=false;
        for (int count:charCounts) {
            length+=count/2*2; 
            if (count%2==1) 
            {
                countexit=true;
            }
        }
        if (countexit) {
            length++;
        }
        return length;
    }
}
