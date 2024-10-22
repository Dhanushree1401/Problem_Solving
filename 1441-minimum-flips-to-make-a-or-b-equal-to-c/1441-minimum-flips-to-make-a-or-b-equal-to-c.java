class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (a != 0 || b != 0 || c != 0) {
            int lsbA = a & 1; 
            int lsbB = b & 1; 
            int lsbC = c & 1; 
            if (lsbC == 1) {
                if (lsbA == 0 && lsbB == 0) {
                    count++;
                }
            }
            else {
                count += lsbA + lsbB; 
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return count;
    }
}