import java.util.*;
class Solution {
    public int thirdMax(int[] nums) {
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