/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oldToNew = new HashMap<>();
        Node copy = dfs(node, oldToNew);
        return copy;
    }

    Node dfs(Node node, Map<Node, Node> oldToNew) {
        if(node==null)
            return null;
            
        if(oldToNew.containsKey(node))
            return oldToNew.get(node);
        
        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for(Node next: node.neighbors) {
            copy.neighbors.add(dfs(next, oldToNew));
        }

        return copy;
    }
}