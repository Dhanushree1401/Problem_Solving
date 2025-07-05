class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> tt=new HashMap<>();
        for(int n:arr)
        {
            tt.put(n,tt.getOrDefault(n,0)+1);
        }
        int luck=-1;
        for(int i:tt.keySet())
        {
            if(tt.get(i)==i)
            {
                luck=i;
            }
        }
        return luck;
    }
}