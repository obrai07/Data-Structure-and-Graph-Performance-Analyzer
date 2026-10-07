import java.util.Arrays;

/**
 * SearchOperations.java
 * Searching algorithms.
 *
 * Implements Linear Search (works on unsorted data, O(n)) and Binary Search
 * (requires sorted data, O(log n)). Both return a SearchResult carrying the
 * index found, how many comparison "steps" were taken, and elapsed time -
 * used by PerformanceAnalyzer to demonstrate the complexity difference.
 */
public class SearchOperations {

    /** Holds the outcome of a search so it can be compared/displayed uniformly. */
    public static class SearchResult {
        public final int index;      // -1 if not found
        public final int steps;      // number of comparisons made
        public final long timeNanos; // elapsed time in nanoseconds

        public SearchResult(int index, int steps, long timeNanos) {
            this.index = index;
            this.steps = steps;
            this.timeNanos = timeNanos;
        }

        @Override
        public String toString() {
            String found = (index == -1) ? "NOT FOUND" : ("found at index " + index);
            return found + " | steps: " + steps + " | time: " + timeNanos + " ns";
        }
    }

    /** Linear Search: checks elements one by one from the start. O(n) worst case. */
    public static SearchResult linearSearch(int[] arr, int target) {
        long start = System.nanoTime();
        int steps = 0;
        int foundIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == target) {
                foundIndex = i;
                break;
            }
        }
        long elapsed = System.nanoTime() - start;
        return new SearchResult(foundIndex, steps, elapsed);
    }

    /**
     * Binary Search: repeatedly halves the search range. Requires a SORTED array.
     * O(log n) worst case. The array is sorted internally first (on a copy) so
     * the caller doesn't need to pre-sort - but note this sort itself costs
     * O(n log n), which is why binary search only pays off when you search the
     * same sorted data many times.
     */
    public static SearchResult binarySearch(int[] sortedArr, int target) {
        long start = System.nanoTime();
        int steps = 0;
        int low = 0, high = sortedArr.length - 1;
        int foundIndex = -1;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (sortedArr[mid] == target) {
                foundIndex = mid;
                break;
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        long elapsed = System.nanoTime() - start;
        return new SearchResult(foundIndex, steps, elapsed);
    }

    /** Helper: returns a sorted copy of the array (needed before binary search). */
    public static int[] sortedCopy(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }
}
