class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int prefixSum1 = 0, prefixSum2 = 0, maxSum = 0, minSum = 0;

        for(int num : nums){
            prefixSum1 += num;
            prefixSum2 += num;

            maxSum = Math.max(maxSum, prefixSum1);
            minSum = Math.min(minSum, prefixSum2);

            if(prefixSum1 < 0){
                prefixSum1 = 0;
            }

            if(prefixSum2 > 0){
                prefixSum2 = 0;
            }
        }

        return Math.max(maxSum, Math.abs(minSum));
    }
}