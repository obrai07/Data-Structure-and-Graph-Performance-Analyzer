import java.util.Random;

/**
 * PerformanceAnalyzer.java
 * Performance comparison.
 *
 * NEW ADDITION beyond the minimum spec: rather than just comparing search
 * results on whatever small dataset the user manually built, this runs a
 * proper benchmark - generating a large random dataset (user-chosen size)
 * so the O(n) vs O(log n) gap between Linear and Binary Search, and the
 * BFS vs DFS traversal costs on a generated graph, are actually visible
 * and measurable instead of trivial on 4-5 items.
 *
 * Keeps the last run's results so "Display All Results" (main menu option 8)
 * can show them again without re-running the benchmark.
 */
public class PerformanceAnalyzer {

    private SearchOperations.SearchResult lastLinearResult;
    private SearchOperations.SearchResult lastBinaryResult;
    private Graph.TraversalResult lastBfsResult;
    private Graph.TraversalResult lastDfsResult;
    private int lastDatasetSize = -1;

    /**
     * Runs a full benchmark: generates `datasetSize` random integers, searches
     * for `target` using both Linear and Binary Search, builds a simple chain
     * graph of the same size, and runs BFS/DFS from the first vertex.
     */
    public void runBenchmark(int datasetSize, int target) {
        // ---- Searching benchmark ----
        Random rand = new Random();
        int[] unsorted = new int[datasetSize];
        for (int i = 0; i < datasetSize; i++) {
            unsorted[i] = rand.nextInt(datasetSize * 10);
        }
        // guarantee the target exists somewhere so both searches can actually find it
        unsorted[rand.nextInt(datasetSize)] = target;

        int[] sorted = SearchOperations.sortedCopy(unsorted);

        lastLinearResult = SearchOperations.linearSearch(unsorted, target);
        lastBinaryResult = SearchOperations.binarySearch(sorted, target);

        // ---- Graph traversal benchmark ----
        // Build a simple connected chain graph: V0-V1-V2-...-V(n-1), plus a few
        // extra cross edges so BFS/DFS visit orders meaningfully differ.
        Graph graph = new Graph();
        int vertexCount = Math.min(datasetSize, 500); // cap so console output stays readable
        for (int i = 0; i < vertexCount; i++) {
            graph.addVertex("V" + i);
        }
        for (int i = 0; i < vertexCount - 1; i++) {
            graph.addEdge("V" + i, "V" + (i + 1));
        }
        // add a few extra random edges to make BFS/DFS visually diverge
        for (int i = 0; i < vertexCount / 5; i++) {
            int a = rand.nextInt(vertexCount);
            int b = rand.nextInt(vertexCount);
            if (a != b) graph.addEdge("V" + a, "V" + b);
        }

        lastBfsResult = graph.bfs("V0");
        lastDfsResult = graph.dfs("V0");
        lastDatasetSize = datasetSize;
    }

    /** Display the most recent benchmark results as a comparison table. */
    public void displayResults() {
        if (lastDatasetSize == -1) {
            System.out.println("No benchmark has been run yet. Use 'Performance Comparison' first.");
            return;
        }
        System.out.println("=============================================");
        System.out.println(" PERFORMANCE COMPARISON  (dataset size: " + lastDatasetSize + ")");
        System.out.println("=============================================");
        System.out.printf("%-12s %-18s %-10s %-15s%n", "Operation", "Algorithm", "Steps", "Time (ns)");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-12s %-18s %-10d %-15d%n", "Search", "Linear Search", lastLinearResult.steps, lastLinearResult.timeNanos);
        System.out.printf("%-12s %-18s %-10d %-15d%n", "Search", "Binary Search", lastBinaryResult.steps, lastBinaryResult.timeNanos);
        System.out.printf("%-12s %-18s %-10d %-15d%n", "Graph Trav.", "BFS", lastBfsResult.steps, lastBfsResult.timeNanos);
        System.out.printf("%-12s %-18s %-10d %-15d%n", "Graph Trav.", "DFS", lastDfsResult.steps, lastDfsResult.timeNanos);
        System.out.println("=============================================");
        System.out.println("Note: Linear Search is O(n) - steps grow directly with dataset size.");
        System.out.println("      Binary Search is O(log n) - steps grow far more slowly, but");
        System.out.println("      requires the data to be sorted first.");
        System.out.println("      BFS and DFS both visit every reachable vertex (O(V + E)), but");
        System.out.println("      explore in a different order - BFS level-by-level, DFS depth-first.");
    }

    public boolean hasResults() { return lastDatasetSize != -1; }
}
