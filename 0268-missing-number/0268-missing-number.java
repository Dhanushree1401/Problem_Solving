class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int a=0;
        int b=0;
        for(int i=0;i<n;i++)
        {
            a=a^nums[i];
            b=b^i;
        }
        b=b^n;
        return a^b;
    }
}