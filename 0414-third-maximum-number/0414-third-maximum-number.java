import java.util.*;
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int re=0;
        int max1=0,max2=0,max3=0;
        /*for(int i=0;i<nums.length;i++)
        {
        if(nums.length<3)
        {
            re=nums[nums.length-1];
        }
        else
        {
            re= nums[nums.length-3];
        }
        }
        return re;*/
        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        int ans=0;
        ArrayList<Integer> ll = new ArrayList<>(unique);
        Collections.sort(ll);
         if (ll.size() < 3) {
            return ll.get(ll.size() - 1); 
        } else {
            return ll.get(ll.size() - 3); 
        }
    }
}