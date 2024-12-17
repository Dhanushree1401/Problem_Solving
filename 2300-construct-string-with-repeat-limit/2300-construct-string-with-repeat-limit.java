class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
         int letter[]=new int[26];
         StringBuilder sb=new StringBuilder();
         for(char ch:s.toCharArray())
         letter[ch-'a']++;
         for(int i=25;i>=0;--i)
         {
            int index=i-1;
            while(true)
            {
                for(int k=Math.min(repeatLimit,letter[i]);k>0;k--){
                    letter[i]--;
                    sb.append((char)('a'+i));
                }
                if(letter[i]==0)
                break;
                while(index >=0 && letter[index]==0)
                --index;
                if(index < 0) 
                break;
                letter[index]--;
                sb.append((char)('a'+index)); 
            }
         }
         return sb.toString();
    }
}