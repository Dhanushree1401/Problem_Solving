class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] ava = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            ava[nums[i] - 1] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < ava.length; i++){
            if(!ava[i]) 
            {
                ans.add(i+1);
            }
        }
        return ans;
    }
}