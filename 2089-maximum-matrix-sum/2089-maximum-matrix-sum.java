class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int negcount = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                int number = Math.abs(matrix[i][j]);
                if(matrix[i][j]<0)
                    negcount++;
                sum += number;
                min = Math.min(min, number);
            }
        }
        return negcount%2 == 0? sum : sum - 2*min;
       
    }
}