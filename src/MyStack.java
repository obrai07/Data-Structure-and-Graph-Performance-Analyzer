/**
 * MyStack.java
 * Stack implementation.
 *
 * Array-based LIFO stack with push, pop, peek, and display, growing
 * automatically when full, and handling the empty-stack case gracefully
 * instead of crashing.
 */
public class MyStack {

    private int[] data;
    private int top; // index of the top element; -1 means empty

    public MyStack() {
        this(10);
    }

    public MyStack(int initialCapacity) {
        data = new int[Math.max(initialCapacity, 1)];
        top = -1;
    }

    /** Push a value onto the top of the stack. */
    public void push(int value) {
        if (top == data.length - 1) grow();
        data[++top] = value;
    }

    /** Pop (remove and return) the top value. Returns null if the stack is empty. */
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty - cannot pop.");
            return null;
        }
        return data[top--];
    }

    /** Peek at the top value without removing it. Returns null if empty. */
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty - nothing to peek.");
            return null;
        }
        return data[top];
    }

    public boolean isEmpty() { return top == -1; }
    public int size() { return top + 1; }

    /** Display the stack from top to bottom. */
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Top -> [ ");
        for (int i = top; i >= 0; i--) {
            sb.append(data[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append(" ] <- Bottom");
        System.out.println(sb);
    }

    private void grow() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
