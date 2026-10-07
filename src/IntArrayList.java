/**
 * IntArrayList.java
 * Array implementation.
 *
 * A resizable integer array (manually implemented, not java.util.ArrayList)
 * supporting insert, delete, search, and display, with automatic growth
 * when capacity is exceeded.
 */
public class IntArrayList {

    private int[] data;
    private int size;

    public IntArrayList() {
        this(10);
    }

    public IntArrayList(int initialCapacity) {
        data = new int[Math.max(initialCapacity, 1)];
        size = 0;
    }

    /** Insert a value at the end of the array, growing capacity if needed. */
    public void insert(int value) {
        if (size == data.length) {
            grow();
        }
        data[size++] = value;
    }

    /** Insert a value at a specific index, shifting later elements right. */
    public boolean insertAt(int index, int value) {
        if (index < 0 || index > size) return false; // invalid index
        if (size == data.length) grow();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return true;
    }

    /** Delete the first occurrence of a value. Returns false if not found. */
    public boolean delete(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }
                size--;
                return true;
            }
        }
        return false; // value not found
    }

    /** Linear search for a value. Returns its index, or -1 if not found. */
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    /** Display all elements currently in the array. */
    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append(" ]");
        System.out.println(sb);
    }

    private void grow() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    /** Returns a copy of the current elements as a plain int[] (used by searching/graph demos). */
    public int[] toArray() {
        int[] copy = new int[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}
