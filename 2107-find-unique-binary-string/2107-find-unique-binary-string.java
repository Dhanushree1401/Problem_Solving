class Solution {
  class TrieNode {
    TrieNode zero;
    TrieNode one;
  }
  private String dfs(TrieNode p, int n) {
    if (p==null) {
      var s=new StringBuilder();
      while(n-->0) s.append("0");
      return s.toString();
    }
    if(n==1) {
      if(p.zero!=null && p.one!=null) return "?";
      return p.zero==null ? "0" : "1";
    }

    var s=dfs(p.zero,n-1);
    if (!s.equals("?")) return "0" + s;

    s=dfs(p.one,n-1);
    return s.equals("?")?s:"1"+s;
  }

  public String findDifferentBinaryString(String[] nums) {
    var root=new TrieNode();
    for (var a:nums) {
      var p=root;

      for (var c:a.toCharArray()) {
        if (c=='0') {
          if (p.zero==null) p.zero=new TrieNode();
          p=p.zero;
        } else {
          if(p.one==null) p.one=new TrieNode();
          p=p.one;
        }
      }
    }
    return dfs(root, nums[0].length());
  }
}