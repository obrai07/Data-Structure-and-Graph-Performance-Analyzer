# Testing - Data Structure and Graph Performance Analyzer

Manual test cases covering normal operations and the edge cases required by the
assignment (empty structures, invalid input, missing values, duplicates).

## Array and Searching (Member 1 - M.A.M. Affan)

| # | Test Case | Steps | Expected Result | Pass/Fail |
|---|---|---|---|---|
| 1 | Insert values | Menu 1 > 1, insert 5, 10, 15 | Each value inserted; Display shows [ 5, 10, 15 ] |Pass |
| 2 | Insert beyond initial capacity | Insert 15+ values | Array grows automatically, no crash |Pass |
| 3 | Delete existing value | Menu 1 > 2, enter 10 | "Deleted."; value gone from Display |Pass |
| 4 | Delete missing value | Menu 1 > 2, enter 999 | "Value not found." |Pass |
| 5 | Search existing value | Menu 1 > 3, enter 15 | Found at correct index |Pass |
| 6 | Search missing value | Menu 1 > 3, enter 999 | "Not found." |Pass |
| 7 | Display empty array | Menu 1 > 4 on empty array | "Array is empty." |Pass |
| 8 | Linear search | Menu 5 > 1, enter existing value | Index found, steps and time shown |Pass |
| 9 | Binary search | Menu 5 > 2, enter existing value | Index found, fewer steps than linear |Pass |
| 10 | Compare both | Menu 5 > 3 | Both results shown side by side |Pass |
| 11 | Search with empty array | Menu 5 on empty array | Message asking to add values first |Pass |
| 12 | Non-numeric input | Enter "abc" at any number prompt | "Invalid input" and re-prompt, no crash |Pass |

## Stack and Queue (Member 2 - M.M.M. Mashdi)

| # | Test Case | Steps | Expected Result | Pass/Fail |
|---|---|---|---|---|
| 13 | Push values | Menu 2 > 1, push 5 then 10 | Display shows Top -> [ 10, 5 ] <- Bottom |Pass |
| 14 | Pop | Menu 2 > 2 | Returns 10 (LIFO) |Pass |
| 15 | Peek | Menu 2 > 3 | Shows top without removing it |Pass |
| 16 | Pop on empty stack | Pop until empty, then pop again | "Stack is empty - cannot pop.", no crash |Pass |
| 17 | Peek on empty stack | Menu 2 > 3 on empty stack | "Stack is empty - nothing to peek." |Pass |
| 18 | Enqueue values | Menu 3 > 1, enqueue 100 then 200 | Display shows Front -> [ 100, 200 ] <- Rear |Pass |
| 19 | Dequeue | Menu 3 > 2 | Returns 100 (FIFO) |Pass |
| 20 | Peek front | Menu 3 > 3 | Shows 200 without removing it |Pass |
| 21 | Dequeue on empty queue | Dequeue until empty, then again | "Queue is empty - cannot dequeue.", no crash |Pass |
| 22 | Queue wrap-around | Enqueue, dequeue, enqueue repeatedly | Order stays correct (circular array) |Pass |

## Linked List (Member 3 - R.M. Riskan)

| # | Test Case | Steps | Expected Result | Pass/Fail |
|---|---|---|---|---|
| 23 | Insert values | Menu 4 > 1, insert 7, 14, 21 | Display shows HEAD -> 7 -> 14 -> 21 -> NULL |Pass |
| 24 | Delete head | Menu 4 > 2, enter 7 | Head updated correctly |Pass |
| 25 | Delete middle/tail | Delete 14 or 21 | List relinks correctly |Pass |
| 26 | Delete missing value | Menu 4 > 2, enter 999 | "Value not found." |Pass |
| 27 | Search existing value | Menu 4 > 3 | Position shown |Pass |
| 28 | Search missing value | Menu 4 > 3, enter 999 | "Not found." |Pass |
| 29 | Display empty list | Menu 4 > 4 on empty list | "Linked list is empty." |Pass |

## Graph and Performance (Member 4 - S.I.M. Shimak)

| # | Test Case | Steps | Expected Result | Pass/Fail |
|---|---|---|---|---|
| 30 | Add vertices | Menu 6 > 1, add A, B, C, D | Each added |Pass |
| 31 | Duplicate vertex | Add A again | "Vertex already exists." |Pass |
| 32 | Add edges | Menu 6 > 2, A-B, B-C, A-D | Each edge added |Pass |
| 33 | Edge with missing vertex | Add edge A-Z | "Could not add edge" message |Pass |
| 34 | Duplicate edge | Add A-B again | "Could not add edge" message |Pass |
| 35 | Display graph | Menu 6 > 3 | Adjacency list shown correctly |Pass |
| 36 | BFS traversal | Menu 6 > 4, start A | Level-by-level order with steps and time |Pass |
| 37 | DFS traversal | Menu 6 > 5, start A | Depth-first order with steps and time |Pass |
| 38 | Traverse from missing vertex | BFS/DFS from Z | "Vertex not found." |Pass |
| 39 | Display empty graph | Menu 6 > 3 with no vertices | "Graph has no vertices yet." |Pass |
| 40 | Performance comparison | Menu 7, size 2000, target 777 | Table shows Linear steps far higher than Binary steps |Pass |
| 41 | Invalid benchmark size | Menu 7, size 0 or negative | "Dataset size must be positive." |Pass |
| 42 | Display all results | Menu 8 after running benchmark | Last benchmark table shown again |Pass |
| 43 | Display results before any benchmark | Menu 8 on fresh start | "No benchmark has been run yet." |Pass |

## System-wide

| # | Test Case | Steps | Expected Result | Pass/Fail |
|---|---|---|---|---|
| 44 | Invalid main menu choice | Enter 0 or 99 | "Invalid choice" message, menu redisplays |Pass |
| 45 | Submenu navigation | Enter and leave each submenu | Returns to main menu cleanly |Pass |
| 46 | Exit | Menu 9 | "Goodbye!" and program ends |Pass |

