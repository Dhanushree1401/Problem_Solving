import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> f = new HashMap<>();
        for (int ans : answers) {
            f.put(ans, f.getOrDefault(ans, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : f.entrySet()) {
            int ans = entry.getKey(), count = entry.getValue();
            if (ans == 0) res += count;
            else res += (int)Math.ceil((double)count / (ans + 1)) * (ans + 1);
        }
        return res;
    }
}