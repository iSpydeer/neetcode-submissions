/*
Definition for a Node.
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
        final HashMap<Node, Node> oldToNew = new HashMap<>();
        if (node == null) {
            return null;
        } else {
            return dfs(node, oldToNew);
        }
    }

    private Node dfs(Node node, HashMap<Node, Node> oldToNew) {
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        Node newNode = new Node(node.val);
        oldToNew.put(node, newNode);

        node.neighbors.forEach(nbr -> { newNode.neighbors.add(dfs(nbr, oldToNew)); });
        return newNode;
    }
}