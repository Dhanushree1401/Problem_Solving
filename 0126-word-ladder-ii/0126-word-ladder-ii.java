class Solution {
    HashMap<String, Integer> map;
    String beg;
    List<List<String>> L;
    public void dfs(String str, List<String> seq) {
        int level = map.get(str);
        if (str.equals(beg)) {
            List<String> temp = new ArrayList<>(seq);
            Collections.reverse(temp);
            L.add(temp);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                char[] arr = str.toCharArray();
                arr[i] = ch;
                String newString = new String(arr);
                if (map.containsKey(newString) && map.get(newString) + 1 == level) {
                    seq.add(newString);
                    dfs(newString, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String str : wordList) set.add(str);
        beg = beginWord;
        set.remove(beg);
        Queue<String> q = new LinkedList<>();
        q.add(beg);
        map = new HashMap<>();
        map.put(beg, 1);
        while (!q.isEmpty()) {
            String node = q.poll();
            int level = map.get(node);
            if (node.equals(endWord)) break;
            for (int i = 0; i < node.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] arr = node.toCharArray();
                    arr[i] = ch;
                    String newString = new String(arr);
                    if (set.contains(newString)) {
                        set.remove(newString);
                        q.add(newString);
                        map.put(newString, level + 1);
                    }
                }
            }
        }
        L = new ArrayList<>();
        List<String> seq = new ArrayList<>();
        if (map.containsKey(endWord)) {
            seq.add(endWord);
            dfs(endWord, seq);
        }
        return L;
    }
}