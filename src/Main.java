import java.util.Scanner;

/**
 * Main.java
 * ALL MEMBERS: Integration point. Wires together the array (M1), searching
 * (M1), stack + queue (M2), linked list (M3), and graph + performance
 * comparison (M4) behind the menu structure given in the assignment brief.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final IntArrayList arrayList = new IntArrayList();
    private static final MyStack stack = new MyStack();
    private static final MyQueue queue = new MyQueue();
    private static final MyLinkedList linkedList = new MyLinkedList();
    private static final Graph graph = new Graph();
    private static final PerformanceAnalyzer analyzer = new PerformanceAnalyzer();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: linkedListMenu(); break;
                case 5: searchingMenu(); break;
                case 6: graphMenu(); break;
                case 7: performanceMenu(); break;
                case 8: analyzer.displayResults(); break;
                case 9: running = false; System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice. Please select 1-9.");
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("=============================================");
        System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
    }

    // ---------------- Array submenu (Member 1) ----------------

    private static void arrayMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    int value = readInt("Enter value to insert: ");
                    arrayList.insert(value);
                    System.out.println("Inserted " + value + ".");
                    break;
                case 2:
                    int delVal = readInt("Enter value to delete: ");
                    System.out.println(arrayList.delete(delVal) ? "Deleted." : "Value not found.");
                    break;
                case 3:
                    int searchVal = readInt("Enter value to search: ");
                    int idx = arrayList.search(searchVal);
                    System.out.println(idx == -1 ? "Not found." : "Found at index " + idx + ".");
                    break;
                case 4:
                    arrayList.display();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Stack submenu (Member 2) ----------------

    private static void stackMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- STACK OPERATIONS ------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    int value = readInt("Enter value to push: ");
                    stack.push(value);
                    System.out.println("Pushed " + value + ".");
                    break;
                case 2:
                    Integer popped = stack.pop();
                    if (popped != null) System.out.println("Popped: " + popped);
                    break;
                case 3:
                    Integer top = stack.peek();
                    if (top != null) System.out.println("Top: " + top);
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Queue submenu (Member 2) ----------------

    private static void queueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- QUEUE OPERATIONS ------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek/Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    int value = readInt("Enter value to enqueue: ");
                    queue.enqueue(value);
                    System.out.println("Enqueued " + value + ".");
                    break;
                case 2:
                    Integer dequeued = queue.dequeue();
                    if (dequeued != null) System.out.println("Dequeued: " + dequeued);
                    break;
                case 3:
                    Integer front = queue.peekFront();
                    if (front != null) System.out.println("Front: " + front);
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Linked List submenu (Member 3) ----------------

    private static void linkedListMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n------------ LINKED LIST OPERATIONS ---------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    int value = readInt("Enter value to insert: ");
                    linkedList.insert(value);
                    System.out.println("Inserted " + value + ".");
                    break;
                case 2:
                    int delVal = readInt("Enter value to delete: ");
                    System.out.println(linkedList.delete(delVal) ? "Deleted." : "Value not found.");
                    break;
                case 3:
                    int searchVal = readInt("Enter value to search: ");
                    int pos = linkedList.search(searchVal);
                    System.out.println(pos == -1 ? "Not found." : "Found at position " + pos + ".");
                    break;
                case 4:
                    linkedList.display();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Searching submenu (Member 1) ----------------

    private static void searchingMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n------------- SEARCHING OPERATIONS ----------");
            System.out.println("1. Linear Search (on current array)");
            System.out.println("2. Binary Search (on current array, sorted first)");
            System.out.println("3. Compare Both");
            System.out.println("4. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            if (arrayList.isEmpty() && choice != 4) {
                System.out.println("Array is empty - add values via Array Operations first.");
                continue;
            }
            switch (choice) {
                case 1: {
                    int target = readInt("Enter value to search: ");
                    SearchOperations.SearchResult r = SearchOperations.linearSearch(arrayList.toArray(), target);
                    System.out.println("Linear Search result: " + r);
                    break;
                }
                case 2: {
                    int target = readInt("Enter value to search: ");
                    int[] sorted = SearchOperations.sortedCopy(arrayList.toArray());
                    SearchOperations.SearchResult r = SearchOperations.binarySearch(sorted, target);
                    System.out.println("Binary Search result: " + r);
                    break;
                }
                case 3: {
                    int target = readInt("Enter value to search: ");
                    int[] arr = arrayList.toArray();
                    SearchOperations.SearchResult linear = SearchOperations.linearSearch(arr, target);
                    SearchOperations.SearchResult binary = SearchOperations.binarySearch(SearchOperations.sortedCopy(arr), target);
                    System.out.println("Linear Search: " + linear);
                    System.out.println("Binary Search: " + binary);
                    break;
                }
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Graph submenu (Member 4) ----------------

    private static void graphMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--------------- GRAPH OPERATIONS ------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: {
                    String label = readLine("Enter vertex label: ");
                    System.out.println(graph.addVertex(label) ? "Vertex added." : "Vertex already exists.");
                    break;
                }
                case 2: {
                    String a = readLine("Enter first vertex: ");
                    String b = readLine("Enter second vertex: ");
                    System.out.println(graph.addEdge(a, b) ? "Edge added." : "Could not add edge (missing vertex or duplicate).");
                    break;
                }
                case 3:
                    graph.display();
                    break;
                case 4: {
                    String start = readLine("Enter start vertex: ");
                    if (!graph.hasVertex(start)) { System.out.println("Vertex not found."); break; }
                    System.out.println("BFS: " + graph.bfs(start));
                    break;
                }
                case 5: {
                    String start = readLine("Enter start vertex: ");
                    if (!graph.hasVertex(start)) { System.out.println("Vertex not found."); break; }
                    System.out.println("DFS: " + graph.dfs(start));
                    break;
                }
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Performance Comparison (Member 4 / Integration) ----------------

    private static void performanceMenu() {
        System.out.println("\n----------- PERFORMANCE COMPARISON ----------");
        int size = readInt("Enter dataset size to benchmark (e.g. 1000): ");
        if (size <= 0) {
            System.out.println("Dataset size must be positive.");
            return;
        }
        int target = readInt("Enter a target value to search for: ");
        analyzer.runBenchmark(size, target);
        analyzer.displayResults();
    }

    // ---------------- Input helpers ----------------

    private static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }
}
