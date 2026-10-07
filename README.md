# Data Structure and Graph Performance Analyzer

CIT300 Data Structures and Algorithms - Graded Practical Assignment 2

## Project Description

A Java console application demonstrating practical implementations of core
data structures and algorithms: array, stack, queue, linked list, searching
(linear vs binary), and a mandatory graph component with BFS/DFS traversal.
The system includes a Performance Comparison module that benchmarks these
algorithms on a user-chosen dataset size, measuring both step counts and
execution time to demonstrate real algorithmic complexity differences
(O(n) vs O(log n) for searching, O(V+E) for graph traversal).

## Technologies Used

- Java (console-based application, no external libraries)
- Manually implemented data structures (no java.util.ArrayList/Stack/Queue
  used for the core components - built from scratch to demonstrate understanding)

## How to compile and run

From the project root (in Eclipse: just import as a Java project and run `Main.java`):

    javac -d bin src/*.java
    cd bin
    java Main

## File-to-member mapping

| File | Member | Component |
|---|---|---|
| `IntArrayList.java` | Member 1 | Resizable array - insert/delete/search/display |
| `SearchOperations.java` | Member 1 | Linear Search and Binary Search with step/time tracking |
| `MyStack.java` | Member 2 | Array-based stack - push/pop/peek/display, empty handling |
| `MyQueue.java` | Member 2 | Circular array-based queue - enqueue/dequeue/peek/display, empty handling |
| `MyLinkedList.java` | Member 3 | Singly linked list - insert/delete/search/display |
| `Graph.java` | Member 4 | Adjacency-list graph - add vertex/edge, display, BFS, DFS |
| `PerformanceAnalyzer.java` | Member 4 / Integration | Large-scale benchmarking engine, comparison table |
| `Main.java` | All members | Menu-driven console interface integrating all components |

## Main System Features

- Full menu system matching the assignment's example structure (9 main options,
  each with its own submenu)
- Array: insert, delete, search, display, with automatic resizing
- Stack: push, pop, peek, display, with graceful handling of popping an empty stack
- Queue: enqueue, dequeue, peek, display, with graceful handling of dequeuing an empty queue
- Linked List: insert, delete, search, display via traversal
- Searching: Linear Search (O(n)) and Binary Search (O(log n)), run on the
  current array's contents, with step counts shown for direct comparison
- Graph (mandatory component): add vertex, add edge, display adjacency list,
  BFS traversal, DFS traversal
- Performance Comparison: generates a random dataset of a size the user
  chooses (e.g. 2000 elements) and a connected graph of matching size, then
  benchmarks Linear vs Binary Search and BFS vs DFS, recording steps and
  execution time in nanoseconds for each
- Display All Results: re-displays the most recent benchmark without re-running it
- Input validation throughout (invalid menu choices, non-numeric input, empty
  structure operations all handled without crashing)

## Group Members

| Name | Student ID | Assigned Responsibility |
|---|---|---|
| M.A.M. Affan | 23DA2-1177 | Array and Searching implementation (`IntArrayList.java`, `SearchOperations.java`) |
| M.M.M. Mashdi | 23DA2-1018 | Stack and Queue implementation (`MyStack.java`, `MyQueue.java`) |
| R.M. Riskan | 23DA2-0804 | Linked List implementation (`MyLinkedList.java`) |
| S.I.M. Shimak | 23DA2-0616 | Graph implementation and traversal, Performance Comparison, main system integration (`Graph.java`, `PerformanceAnalyzer.java`, `Main.java`) |

### Individual Contributions

**M.A.M. Affan**
- Implemented `IntArrayList` class with insert, delete, search, display, and automatic resizing
- Implemented `SearchOperations` class with Linear Search and Binary Search
- Added step-counting and timing to both search algorithms for performance comparison
- Tested array and searching functionality

**M.M.M. Mashdi**
- Implemented `MyStack` class with push, pop, peek, display
- Implemented `MyQueue` class with enqueue, dequeue, peek, display, using a circular array
- Handled empty-stack and empty-queue cases without crashing
- Tested stack and queue functionality

**R.M. Riskan**
- Implemented `MyLinkedList` class with insert, delete, search, display
- Implemented traversal-based display and search logic
- Tested linked list functionality including edge cases (empty list, single node)

**S.I.M. Shimak**
- Implemented `Graph` class using an adjacency list
- Implemented add vertex, add edge, display graph, BFS traversal, DFS traversal
- Implemented `PerformanceAnalyzer` for large-scale random-data benchmarking
- Integrated all components into the main menu-driven application (`Main.java`)
- Tested the complete integrated system

**All Members:** Integration, validation, testing, debugging, documentation, and GitHub collaboration (branches, commits, pull requests).
