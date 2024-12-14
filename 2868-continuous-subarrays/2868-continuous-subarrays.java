import java.util.*;

public class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int[][] minTable = buildMinTable(nums);
        int[][] maxTable = buildMaxTable(nums);

        long result = 0;
        for (int i = 0; i < n; ++i) {
            int low = i, high = n - 1;

            while (low < high) {
                int mid = (low + high + 1) / 2;
                int minVal = query(minTable, i, mid);
                int maxVal = queryMax(maxTable, i, mid);

                if (maxVal - minVal > 2) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }

            result += high - i + 1;
        }
        return result;
    }

    private int lg2(int x) {
        return x == 0 ? -1 : 31 - Integer.numberOfLeadingZeros(x);
    }

    private int[][] buildMinTable(int[] a) {
        int n = a.length;
        int maxK = lg2(n) + 1;
        int[][] minTable = new int[maxK][n];

        for (int i = 0; i < n; ++i) {
            minTable[0][i] = a[i];
        }

        for (int k = 1; (1 << k) <= n; ++k) {
            for (int i = 0; i + (1 << k) <= n; ++i) {
                minTable[k][i] = Math.min(minTable[k - 1][i], minTable[k - 1][i + (1 << (k - 1))]);
            }
        }
        return minTable;
    }

    private int[][] buildMaxTable(int[] a) {
        int n = a.length;
        int maxK = lg2(n) + 1;
        int[][] maxTable = new int[maxK][n];

        for (int i = 0; i < n; ++i) {
            maxTable[0][i] = a[i];
        }

        for (int k = 1; (1 << k) <= n; ++k) {
            for (int i = 0; i + (1 << k) <= n; ++i) {
                maxTable[k][i] = Math.max(maxTable[k - 1][i], maxTable[k - 1][i + (1 << (k - 1))]);
            }
        }
        return maxTable;
    }

    private int query(int[][] table, int x, int y) {
        int k = lg2(y - x + 1);
        return Math.min(table[k][x], table[k][y - (1 << k) + 1]);
    }

    private int queryMax(int[][] table, int x, int y) {
        int k = lg2(y - x + 1);
        return Math.max(table[k][x], table[k][y - (1 << k) + 1]);
    }
}