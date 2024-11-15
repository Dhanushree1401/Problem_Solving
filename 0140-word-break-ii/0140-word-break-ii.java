class Solution {
    public void backtrack(String s, int start, List<String> wordDict, StringBuilder temp, List<String> res) {
        if (start == s.length()) {

            res.add(new String(temp.toString().trim())); 
            return;
        }
        
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (wordDict.contains(substring)) {
                int tempLength = temp.length();
                temp.append(substring).append(" ");
                backtrack(s, end, wordDict, temp, res);
                temp.setLength(tempLength); 
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        backtrack(s,0,wordDict,new StringBuilder(),res);
        return res;
    }
}