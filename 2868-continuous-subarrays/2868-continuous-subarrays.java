class Solution {
    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0, j = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            int minElem = map.firstKey();
            int maxElem = map.lastKey();
            int diff = maxElem - minElem;

            while (diff > 2) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
                minElem = map.firstKey();
                maxElem = map.lastKey();
                diff = maxElem - minElem;
            }

            ans += (j - i + 1);
            j++;
        }

        return ans;
    }
}