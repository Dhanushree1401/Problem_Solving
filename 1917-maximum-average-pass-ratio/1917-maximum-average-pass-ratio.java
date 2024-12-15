import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        double x = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = gain(a[0], a[1]);
            double gainB = gain(b[0], b[1]);
            return Double.compare(gainB, gainA);
        });

        for (int[] s : classes) {
            pq.offer(s);
        }

        while (extraStudents-- > 0) {
            int[] s = pq.poll();
            s[0]++;
            s[1]++;
            pq.offer(s);
        }

        double max = 0;
        while (!pq.isEmpty()) {
            int[] s = pq.poll();
            max += (double) s[0] / s[1];
        }

        return max / n;
    }

    private double gain(int a, int b) {
        double currentRatio = (double) a / b;
        double newRatio = (double) (a + 1) / (b + 1);
        return newRatio - currentRatio;
    }
}