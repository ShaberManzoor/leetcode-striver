package StacksAndQueues.Learning;

public class MyQueue {
    private int n;
    private int arr[];
    private int front = -1, rear = -1, size = 0;

    public MyQueue(int n){
        this.n = n;
        arr = new int[n];
    }

    public void enqueue(int x) {
        if(size==n){
            System.out.println("Queue Overflow");
            return;
        }

        if(rear==-1){
            front = 0;
            rear = 0;
        }else{
            rear = (rear + 1) % n;
        }

        arr[rear] = x;
        size++;
    }

    public int dequeue(){
        if(size==0){
            return -1;
        }

        int val = arr[front];
        size--;

        if(size==0){
            front = rear = -1;
        }else{
            front = (front + 1) % n;
        }
        
        return val;
    }

    public int getFront(){
        if(size==0) return -1;
        return arr[front];
    }

    public int getRear(){
        if(size==0) return -1;
        return arr[rear];
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        return size==n;
    }
}
