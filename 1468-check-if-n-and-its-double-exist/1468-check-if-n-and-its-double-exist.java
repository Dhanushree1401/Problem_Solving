class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer>ss=new HashSet<>();
        for(int num:arr)
        {
            if(ss.contains(num*2)||(num%2==0 && ss.contains(num/2)))
            {
                return true;
            }
            ss.add(num);
        }
        return false;
    }
}