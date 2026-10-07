/**
 * MyLinkedList.java
 * Linked List implementation.
 *
 * A singly linked list of integers supporting insert (at end), delete
 * (first matching value), search, and display via traversal.
 */
public class MyLinkedList {

    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private Node head;
    private int size;

    /** Insert a value at the end of the list. */
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }

    /** Insert a value at the front of the list. */
    public void insertAtFront(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /** Delete the first node matching the given value. Returns false if not found. */
    public boolean delete(int value) {
        if (head == null) return false;
        if (head.value == value) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false; // not found
    }

    /** Search for a value. Returns its position (0-indexed) or -1 if not found. */
    public int search(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value == value) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    /** Display the list by traversing from head to tail. */
    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("HEAD -> ");
        Node current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        sb.append(" -> NULL");
        System.out.println(sb);
    }

    public int size() { return size; }
    public boolean isEmpty() { return head == null; }
}
