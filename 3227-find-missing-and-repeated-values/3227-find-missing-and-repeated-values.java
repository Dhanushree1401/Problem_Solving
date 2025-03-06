class Solution 
{
    public int[] findMissingAndRepeatedValues(int[][] grid) 
    {
        // Step 1: Initialize the map array
        int n = grid.length;
        int[] map = new int[n * n + 1];
        int[] ans = new int[2];

        // Step 2: Traverse the grid to fill the map with occurrences of each number.
        for(int i = 0; i < n; i++) 
        {
            for(int j = 0; j < n; j++) 
            {
                map[grid[i][j]]++;
            }
        }

        // Step 3: Check the map for the repeated and missing numbers.
        for(int i = 0; i < map.length; i++) 
        {
            if(map[i] == 2) 
            {
                ans[0] = i;  // Repeated number.
            }
            
            if(map[i] == 0) 
            {
                ans[1] = i;  // Missing number.
            }
        }

        // Step 4: Return the result.
        return ans;            
    }
}