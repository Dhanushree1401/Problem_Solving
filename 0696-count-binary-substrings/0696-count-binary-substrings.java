class Solution {
    public int countBinarySubstrings(String s) {
        int curr=1,prev=0,re=0;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                curr++;
            }
            else
            {
                re+=Math.min(curr,prev);
                prev=curr;
                curr=1;
            }
        }
        return re+Math.min(curr,prev);
    }
}