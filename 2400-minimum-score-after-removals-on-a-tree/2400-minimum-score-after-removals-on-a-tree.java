class Solution {
    List<Integer>[] graph;
    int[] nums;
    int[] xor;        // stores subtree XORs
    int[] parent;     // stores parent of each node

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        graph = new ArrayList[n];
        xor = new int[n];
        parent = new int[n];

        // Initialize graph
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // Build undirected tree
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // DFS from root to compute XOR and parent
        dfs(0, -1);

        int minScore = Integer.MAX_VALUE;

        // Try all pairs of removable edges (i.e., nodes except root)
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = i, b = j;

                int x, y, z;

                if (isAncestor(a, b)) {
                    // a is ancestor of b
                    x = xor[b];
                    y = xor[a] ^ xor[b];
                    z = xor[0] ^ xor[a];
                } else if (isAncestor(b, a)) {
                    // b is ancestor of a
                    x = xor[a];
                    y = xor[b] ^ xor[a];
                    z = xor[0] ^ xor[b];
                } else {
                    // a and b are in different branches
                    x = xor[a];
                    y = xor[b];
                    z = xor[0] ^ xor[a] ^ xor[b];
                }

                int max = Math.max(x, Math.max(y, z));
                int min = Math.min(x, Math.min(y, z));

                minScore = Math.min(minScore, max - min);
            }
        }

        return minScore;
    }

    // DFS to compute subtree XORs and parent relationship
    private void dfs(int node, int par) {
        xor[node] = nums[node];
        parent[node] = par;
        for (int neighbor : graph[node]) {
            if (neighbor == par) continue;
            dfs(neighbor, node);
            xor[node] ^= xor[neighbor];
        }
    }

    // Check if u is ancestor of v
    private boolean isAncestor(int u, int v) {
        while (v != -1) {
            if (v == u) return true;
            v = parent[v];
        }
        return false;
    }
}