class Solution {
    public boolean splitString(String s) {
        if (s==null || s.length()<=1) return false;
        return backtrack(0, s, new ArrayList<Long>());
    }
    public boolean backtrack(int pos, String s, ArrayList<Long> list) {
        if (pos >= s.length()) return list.size() >= 2; 
        long num=0;
        for (int i=pos; i<s.length(); i++) {
            num=num*10+(s.charAt(i)-'0'); 
            if (list.size()==0 || list.get(list.size()-1) - num == 1) {
                list.add(num);
                if (backtrack(i+1,s,list)) return true;
                list.remove(list.size()-1);
            }
        }
        return false;
    }
}