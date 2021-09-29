package practice;

public class CircularQueue {

    private int max;
    private int front;
    private int rear;
    private int num;
    private int [] queue;




    public CircularQueue(int capacity) {

        num = front = rear = 0;
        max = capacity;
        queue = new int[max];

    }
    public int enqueue(int x) {

        if(isFull()) {
            System.out.println("Circular Queue is Full!");
            return -1;
        }
        rear = (++rear) % max;
        queue[rear] = x;
        return x;

    }
    public int deque() {
        if(isEmpty()) {
            System.out.println("Circular Queue is Empty!");
            return -1;
        }

        int removeIndex = front;
        front = (++front) % max;

        return queue[removeIndex];

    }
    public int peek() {

        return queue[front];

    }
    public boolean isEmpty() {
        return front == rear;
    }
    public boolean isFull() {
        return (rear + 1) % max == front;
    }


}