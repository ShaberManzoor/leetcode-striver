package StacksAndQueues.Learning;

public class MyStack {
    private int n;
    private int arr[];
    private int ptr = -1;

    public MyStack(int n){
        this.n = n;
        arr = new int[n];
    }

    public void push(int x){
        if(ptr<n-1){
            ptr++;
            arr[ptr] = x;
        }
    }

    public int pop(){
        if(ptr==-1) return -1;
        return arr[ptr--];
    }

    public int peek() {
        if(ptr==-1) return -1;
        return arr[ptr];
    }

    public boolean isEmpty(){
        return ptr==-1;
    }

    public boolean isFull() {
        return ptr==n-1;
    }
}
