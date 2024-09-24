class Solution {
    public int singleNumber(int[] nums) {
          int re = 0;
        for (int num : nums) {
            re ^= num; 
        }
        return re;
    }
}