class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int count = 0;
        long sum = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count++;
            }else{
                sum += ((long)count * (long)(count + 1)) / 2;
                count = 0;
            }
        }

        sum += ((long)count * (long)(count + 1)) / 2;
        return sum;
    }
}