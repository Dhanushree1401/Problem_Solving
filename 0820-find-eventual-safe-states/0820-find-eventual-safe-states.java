class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] isSafeNode = new boolean[n];
        boolean[] vis = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, vis, isSafeNode)) {
                ans.add(i);
            }
        }
        return ans;
    }

    boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] isSafeNode) {
        if (vis[node]) {
            return isSafeNode[node];
        }
        vis[node] = true;
        boolean status = true;
        for (int i : graph[node]) {
            status = (status && dfs(i, graph, vis, isSafeNode));
            if (!status) {
                break;
            }
        }
        return isSafeNode[node] = status;
    }
}