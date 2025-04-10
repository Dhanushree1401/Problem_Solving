class Solution {
    public int minOperations(int[] nums, int k) {
        for(int num:nums)
        {
            if(num<k)
            {
                return -1;
            }
        }
        Set<Integer>greater=new HashSet<>();
        for(int i:nums)
        {
            if(i>k)
            {
                greater.add(i);
            }
        }
        return greater.size();
    }
}