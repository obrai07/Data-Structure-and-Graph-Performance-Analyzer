import java.util.*;

/**
 * Graph.java
 * Graph implementation and traversal.
 *
 * An undirected graph represented using an adjacency list. Vertices are
 * labeled with Strings (e.g. "A", "B", "C") so traversal output is easy to
 * read. Provides add vertex, add edge, display, and both BFS and DFS
 * traversal, each returning step/time info for performance comparison.
 */
public class Graph {

    private final Map<String, List<String>> adjacencyList = new LinkedHashMap<>();

    /** Result of a traversal: the visit order plus step/time metrics. */
    public static class TraversalResult {
        public final List<String> order;
        public final int steps;       // number of vertices visited
        public final long timeNanos;

        public TraversalResult(List<String> order, int steps, long timeNanos) {
            this.order = order;
            this.steps = steps;
            this.timeNanos = timeNanos;
        }

        @Override
        public String toString() {
            return order + " | steps: " + steps + " | time: " + timeNanos + " ns";
        }
    }

    /** Add a new vertex. Returns false if it already exists. */
    public boolean addVertex(String label) {
        if (adjacencyList.containsKey(label)) return false;
        adjacencyList.put(label, new ArrayList<>());
        return true;
    }

    /** Add an undirected edge between two existing vertices. */
    public boolean addEdge(String a, String b) {
        if (!adjacencyList.containsKey(a) || !adjacencyList.containsKey(b)) return false;
        if (adjacencyList.get(a).contains(b)) return false; // edge already exists
        adjacencyList.get(a).add(b);
        adjacencyList.get(b).add(a);
        return true;
    }

    /** Display the full adjacency list. */
    public void display() {
        if (adjacencyList.isEmpty()) {
            System.out.println("Graph has no vertices yet.");
            return;
        }
        System.out.println("---- Graph (Adjacency List) ----");
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public boolean hasVertex(String label) {
        return adjacencyList.containsKey(label);
    }

    public Set<String> getVertices() {
        return adjacencyList.keySet();
    }

    /** Breadth-First Search: explores level by level using a queue. */
    public TraversalResult bfs(String start) {
        List<String> order = new ArrayList<>();
        if (!adjacencyList.containsKey(start)) return new TraversalResult(order, 0, 0);

        long startTime = System.nanoTime();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        int steps = 0;

        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);
            steps++;
            for (String neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        long elapsed = System.nanoTime() - startTime;
        return new TraversalResult(order, steps, elapsed);
    }

    /** Depth-First Search: explores as deep as possible before backtracking. */
    public TraversalResult dfs(String start) {
        List<String> order = new ArrayList<>();
        if (!adjacencyList.containsKey(start)) return new TraversalResult(order, 0, 0);

        long startTime = System.nanoTime();
        Set<String> visited = new HashSet<>();
        dfsHelper(start, visited, order);
        long elapsed = System.nanoTime() - startTime;
        return new TraversalResult(order, order.size(), elapsed);
    }

    private void dfsHelper(String current, Set<String> visited, List<String> order) {
        visited.add(current);
        order.add(current);
        for (String neighbour : adjacencyList.get(current)) {
            if (!visited.contains(neighbour)) {
                dfsHelper(neighbour, visited, order);
            }
        }
    }
}
