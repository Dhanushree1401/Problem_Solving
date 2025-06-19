class Solution {
    public int totalFruit(int[] fruits) {
        int count=0;
        int n=fruits.length;
        if(n==1 || n==2)
        {
            return n;
        }
        int max=2;
        int b1=fruits[0];
        int b2=-1;
        int countb1=1;
        int countb2=0;
        int sum=0,i=0;
        for(int j=1;j<n;j++)
        {
            int end=fruits[j];
            if(end==b1)
            {
                countb1++;
            }
            else if(end==b2)
            {
                countb2++;
            }
            else if(countb1==0)
            {
                b1=end;
                countb1++;
            }
            else if(countb2==0)
            {
                b2=end;
                countb2++;
            }
            else
            {
              while(countb1 != 0 && countb2 != 0){
                    int start = fruits[i];
                    if(start == b1){
                        countb1--; 
                    } else {
                        countb2--; 
                    }
                    i++; 
                }
                if(countb1 == 0){
                    b1 = end;
                    countb1 = 1;
                } else {
                    b2 = end;
                    countb2 = 1;
                }
            }
            sum = countb1 + countb2;
            max = Math.max(max, sum);
        }
        return max; 
    }
}