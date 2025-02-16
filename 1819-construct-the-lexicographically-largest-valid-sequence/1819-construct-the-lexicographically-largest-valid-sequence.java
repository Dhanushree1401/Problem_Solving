class Solution {
    public boolean[] visited;
    public int[] res;
    public int[] constructDistancedSequence(int n) {
        res=new int[2*n-1];
        visited = new boolean[n + 1];
        backtrack(n, 0);
        return res;
    }

    public boolean backtrack(int n, int k) {
        if(k == res.length)
            return true;
        if(res[k] != 0)
            return backtrack(n, k + 1);
        for(int i = n; i >= 1; i--) {
            if (visited[i])
                continue;
            visited[i] = true;
            res[k] = i;
            if(i == 1) {
                if(backtrack(n, k + 1))
                    return true;
            } 
            else if(k + i < res.length && res[k + i] == 0) {
                res[k + i] = i;
                if(backtrack(n, k + 1))
                    return true;
                res[k + i] = 0;
            }
            res[k] = 0;
            visited[i] = false;
        }
        return false;
    }
}

//nnn