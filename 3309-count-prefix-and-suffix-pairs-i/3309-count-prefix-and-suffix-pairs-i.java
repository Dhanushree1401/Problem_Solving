class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n=words.length;
        int res=0;
        for(int i=0;i<n;i++)
        {
            String s1=words[i];
            for(int j=i+1;j<n;j++)
            {
                String s2=words[j];
                if(s2.length()<s1.length())
                {
                    continue;
                }
                String pre=s2.substring(0,s1.length());
                String pre1=s2.substring(s2.length()-s1.length());
                if(pre.equals(s1) && pre1.equals(s1))
                {
                    res++;
                }
            }
        }
        return res;
    }
}