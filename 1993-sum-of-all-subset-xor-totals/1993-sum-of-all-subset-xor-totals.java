class Solution {
    int ans=0;
    public int subsetXORSum(int[] nums) {
        List<Integer> al=new ArrayList<>();
        findAns(0,nums,al);
        return ans;
    }

    public void findAns(int index,int[] nums,List<Integer> al){
        if(index==nums.length){
            int result=0;
            for (int num : al) {
               result^=num;
            }
            ans+=result;
            return;
        }
        al.add(nums[index]);
        findAns(index+1,nums,al);
        al.remove(al.size()-1);
        findAns(index+1,nums,al);
    }
}