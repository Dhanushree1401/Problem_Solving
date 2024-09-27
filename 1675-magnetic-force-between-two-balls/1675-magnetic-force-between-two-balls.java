class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left=1,right=position[position.length-1]-position[0];
        int re=0;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(place(position,m,mid))
            {
                re=mid;
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return re;
    }
    private static boolean place(int[] position,int m,int mid)
    {
      int count=1;
      int last=position[0];
       for(int i=1;i<position.length;i++) {
            if(position[i]-last>=mid) {
                count++; 
                last=position[i];
            }
            if(count==m) {
                return true; 
            }
       }
       return false;
    }
}