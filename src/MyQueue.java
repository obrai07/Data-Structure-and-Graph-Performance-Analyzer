/**
 * MyQueue.java
 * Queue implementation.
 *
 * Array-based circular FIFO queue with enqueue, dequeue, peek/front, and
 * display, growing automatically when full, and handling the empty-queue
 * case gracefully instead of crashing.
 */
public class MyQueue {

    private int[] data;
    private int front;
    private int rear;
    private int count; // number of elements currently stored

    public MyQueue() {
        this(10);
    }

    public MyQueue(int initialCapacity) {
        data = new int[Math.max(initialCapacity, 1)];
        front = 0;
        rear = -1;
        count = 0;
    }

    /** Add a value to the back of the queue. */
    public void enqueue(int value) {
        if (count == data.length) grow();
        rear = (rear + 1) % data.length;
        data[rear] = value;
        count++;
    }

    /** Remove and return the value at the front of the queue. Returns null if empty. */
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty - cannot dequeue.");
            return null;
        }
        int value = data[front];
        front = (front + 1) % data.length;
        count--;
        return value;
    }

    /** Look at the front value without removing it. Returns null if empty. */
    public Integer peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty - nothing to peek.");
            return null;
        }
        return data[front];
    }

    public boolean isEmpty() { return count == 0; }
    public int size() { return count; }

    /** Display the queue from front to rear. */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Front -> [ ");
        for (int i = 0; i < count; i++) {
            int idx = (front + i) % data.length;
            sb.append(data[idx]);
            if (i < count - 1) sb.append(", ");
        }
        sb.append(" ] <- Rear");
        System.out.println(sb);
    }

    private void grow() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < count; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        rear = count - 1;
    }
}
