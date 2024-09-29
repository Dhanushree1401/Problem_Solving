class Solution {
    int max;
    private void solveBacktrack(int[][] students, int[][] mentors, int pos, int score, boolean[] vis) {
        if (pos >= students.length) {
            max = Math.max(max, score);
            return;
        }
        for (int i=0;i<mentors.length;i++) {
            if (!vis[i]){
                vis[i]=true;
                solveBacktrack(students,mentors,pos+1,score+helper(students[pos],mentors[i]),vis);
                vis[i]=false;
            }
        }
    }

    private int helper(int[] student,int[] mentor) {
        int count=0;
        for (int i=0;i<mentor.length;i++) {
            if (student[i]==mentor[i])
                count++;
        }
        return count;
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        boolean[] vis = new boolean[students.length];
        solveBacktrack(students, mentors,0,0,vis);
        return max;
    }
}