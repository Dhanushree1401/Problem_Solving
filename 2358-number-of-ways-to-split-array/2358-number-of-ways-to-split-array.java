class Solution {
    public int waysToSplitArray(int[] nums) {
     int len=nums.length;
     long totalsum=0;
     for(int i:nums)
     {
        totalsum+=i;
     }  
     int count=0;
     long left=0;
     for(int i=0;i<len-1;i++)
     {
        left+=nums[i];
        long right=totalsum-left;
        if(left>=right)
        {
        count++;
        }
     } 
     return count;
    }
}