class Solution {
    public int[] minOperations(String boxes) {
        List<Integer> pos = new ArrayList<>();
        int len = boxes.length();
        int[] ans = new int[len];
        
        for(int i = 0; i < len; i++)
            if(boxes.charAt(i) == '1')
                pos.add(i);
        
        for(int i = 0; i < len; i++) {
            int sum = 0;
            for(int idx : pos) {
                int dst = Math.abs(i - idx);
                sum += dst;
            }
            ans[i] = sum;
        }
        return ans;
    }
}