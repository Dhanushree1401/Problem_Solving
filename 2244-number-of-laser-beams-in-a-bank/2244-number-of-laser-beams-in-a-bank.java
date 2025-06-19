class Solution {
    public int numberOfBeams(String[] bank) {
        if (bank.length < 2) {
            return 0;
        }
        int solution = 0;
        int prev = 0;
        int cur = 0;
        for (String row : bank) {
            cur = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') {
                    cur++;
                }
            }
            solution += cur * prev;
            prev = cur == 0 ? prev : cur;
        }
        return solution;
    }
}