class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visit=grid;
        Queue<int[]>qq=new LinkedList<>();
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visit[i][j]==2)
                {
                    qq.offer(new int[]{i,j});
                }
                if(visit[i][j]==1)
                {
                    count++;
                }
            }
        }
        if(count==0)
        {
            return 0;
        }
        if(qq.isEmpty())
        {
            return -1;
        }
        int minutes=-1;
        int[][] dd={{1,0},{-1,0},{0,-1},{0,1}};
        while(!qq.isEmpty())
        {
            int size=qq.size();
            while(size-->0)
            {
                int[] cell=qq.poll();
                int x=cell[0];
                int y=cell[1];
                for(int[] dir:dd)
                {
                    int i=x+dir[0];
                    int j=y+dir[1];
                    if(i>=0 && i<m && j>=0 && j<n && visit[i][j]==1)
                    {
                        visit[i][j]=2;
                        count--;
                        qq.offer(new int[]{i,j});
                    }
                }
            }
            minutes++;
        }
        if(count==0)
        {
            return minutes;
        }
        return -1;
    }
}