class Solution {
    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }
        
        char[] chars = s.toCharArray();
        int j = 2;
        
        for (int i = 2; i < chars.length; ++i) {
            if (chars[i] != chars[j - 1] || chars[i] != chars[j - 2]) {
                chars[j++] = chars[i];
            }
        }
        
        return new String(chars, 0, j);
    }
}