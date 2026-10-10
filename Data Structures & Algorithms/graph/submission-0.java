class Graph {

    private final HashMap<Integer, HashSet<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        adjList.putIfAbsent(src, new HashSet<>());
        adjList.putIfAbsent(dst, new HashSet<>());
        adjList.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if (!adjList.containsKey(src)) {
            return false;
        }

        return adjList.get(src).remove(dst);
    }

    public boolean hasPath(int src, int dst) {
        return hasPathDfs(src, dst, new HashSet<>());
    }

    private boolean hasPathDfs(int src, int dst, HashSet<Integer> visited) {
        if (src == dst) {
            return true;
        }

        visited.add(src);
        for (int nbr: adjList.getOrDefault(src, new HashSet<>())) {
            if (!visited.contains(nbr) && hasPathDfs(nbr, dst, visited)) {
                return true;
            }
        }

        return false;
    }
}
