import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer>ll=new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j])
                {
                   ll.add(nums1[i]);
                   nums2[j] = Integer.MIN_VALUE;
                   break;
                }
            }
        }
        int[] re=new int[ll.size()];
        for(int i=0;i<re.length;i++)
        {
           re[i]=ll.get(i);
        }
        return re;
    }
}