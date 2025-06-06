class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] minSuf = new char[n];
        minSuf[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; --i)
            minSuf[i] = s.charAt(i) < minSuf[i + 1] ? s.charAt(i) : minSuf[i + 1];
        char[] stack = new char[n];
        int top = 0;
        StringBuilder p = new StringBuilder(n);
        int i = 0;
        while (i < n) {
            while (top > 0 && stack[top - 1] <= minSuf[i]) {
                p.append(stack[--top]);
            }
            stack[top++] = s.charAt(i);
            ++i;
        }
        while (top > 0) {
            p.append(stack[--top]);
        }
        return p.toString();
    }
}