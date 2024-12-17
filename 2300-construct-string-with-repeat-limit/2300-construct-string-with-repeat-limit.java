class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int [] vocab = new int[26]; 
        for (char ch : s.toCharArray()) vocab[ch - 'a']++;
        StringBuilder sb = new StringBuilder();
        int idx = 25;
        while (idx >= 0) {
            if (vocab[idx] == 0) {
                idx--;
                continue;
            }
            int count = Math.min(vocab[idx], repeatLimit);
            for (int i = 0 ; i < count ; i++) sb.append((char)(idx + 'a'));
            vocab[idx] -= count;
            if (vocab[idx] > 0) {  
                int next = idx - 1;
                while (next >= 0 && vocab[next] == 0) next--; 
                if (next < 0) break;
                sb.append((char) (next + 'a')); 
                vocab[next]--;
            }
        }
        return sb.toString();
    }
}