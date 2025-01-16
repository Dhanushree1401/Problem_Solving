class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
       int res=0,x1=0,x2=0;
       for(int n1:nums1) x1^=n1;
       for(int n2:nums2) x2^=n2;
       if(nums1.length%2==1) res^=x2;
       if(nums2.length%2==1) res^=x1;
       return res;
    }
}