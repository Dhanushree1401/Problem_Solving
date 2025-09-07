class Solution {
    public long minOperations(int[][] queries) {
        long totalOperations = 0;
        
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            totalOperations += calculateOperations(l, r);
        }
        
        return totalOperations;
    }
    
    private long calculateOperations(int l, int r) {
        long totalSteps = 0;
        int maxSteps = 0;
        
        for (int step = 0; step <= 16; step++) {
            long lowerBound = (1L << (2 * step));
            long upperBound = (1L << (2 * (step + 1))) - 1;
            
            if (lowerBound > r) break;
            
            long rangeStart = Math.max(l, lowerBound);
            long rangeEnd = Math.min(r, upperBound);
            
            if (rangeStart > rangeEnd) continue;
            
            long count = rangeEnd - rangeStart + 1;
            totalSteps += count * (step + 1);
            maxSteps = Math.max(maxSteps, step + 1);
        }
        
        return Math.max(maxSteps, (totalSteps + 1) / 2);
    }
}