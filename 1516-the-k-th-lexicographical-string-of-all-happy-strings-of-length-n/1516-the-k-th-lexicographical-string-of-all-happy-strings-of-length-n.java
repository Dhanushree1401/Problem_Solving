class Solution {
    List<String> list = new ArrayList<>();
    public String getHappyString(int n, int k) {
        StringBuilder res = new StringBuilder("");
        helper(n, list, res);

        if(list.size() < k) return "";

        return list.get(k-1);
    }

    public void helper(int n, List<String> list, StringBuilder sb) {
        if(sb.length() == n) {
            list.add(sb.toString());
            return;
        }

        for(char ch='a'; ch<='c'; ch++) {
            if(sb.length()>0 && sb.charAt(sb.length()-1) == ch) continue;
            sb.append(ch);
            helper(n, list, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}