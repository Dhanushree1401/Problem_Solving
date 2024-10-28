class Solution {
    public static boolean check(int i,int idx,String words[])
    {
        return words[idx].charAt(i)=='a' || words[idx].charAt(i)=='e' || words[idx].charAt(i)=='i' || words[idx].charAt(i)=='u' || words[idx].charAt(i)=='o';
    }
    public int vowelStrings(String[] words, int left, int right) 
    {
        int ans=0;
        for(int i=left;i<=right;i++)
        {
            if(check(0,i,words) && check(words[i].length()-1,i,words))
            {
                ans+=1;
            }
        }
        return ans;
    }
}