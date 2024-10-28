class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer,Integer>mm=new HashMap<>();
        Arrays.sort(nums);
        int res=-1;
        for(int num:nums)
        {
            int sqrt=(int)Math.sqrt(num);
            if(sqrt*sqrt==num && mm.containsKey(sqrt))
            {
                mm.put(num,mm.get(sqrt)+1);
                res=Math.max(res,mm.get(num));
            }
            else
            {
                mm.put(num,1);
            }
        }
        return res;
    }
}