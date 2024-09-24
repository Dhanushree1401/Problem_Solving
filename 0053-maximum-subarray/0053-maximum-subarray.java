import java.util.ArrayList;
class Solution {
    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        ArrayList<Integer>gg=new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            gg.add(curr);
            max = Math.max(max, curr);
        }
        System.out.println(gg);
        return max;
    }
       /* return gg;*/
      /*  public ArrayList<Integer> gg(int[] nums) {
        int curr = nums[0];
        ArrayList<Integer> gg = new ArrayList<>();
        gg.add(curr);  
        
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            gg.add(curr); 
        }
        return gg;*/
}