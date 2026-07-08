package StacksAndQueues.ImpProblems;

import java.util.HashMap;
import java.util.Map;

class Node {
    Node prev, next;
    int key, val;

    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class DoublyLL {
    //we will add every node between these two nodes
    Node head, tail;

    DoublyLL(){
        head = new Node(-1, -1); 
        tail = new Node(-1, -1); 

        head.next = tail;
        tail.prev = head;
    }

    //adding the element at first after the head node
    public void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //reoving the last node
    public Node removeLast(){
        Node lastNode = tail.prev;

        lastNode.prev.next = lastNode.next;
        lastNode.next.prev = lastNode.prev;

        return lastNode;
    }
}

public class LRUCache {
    private int capacity;

    private Map<Integer, Node> keyToNode; //For efficintly fetching the node with the desired key
    private DoublyLL dll; //to store in lru order

    public LRUCache(int cap) {
        capacity = cap;

        keyToNode = new HashMap<>();
        dll = new DoublyLL();
    }

    public int get(int key) {
        if(!keyToNode.containsKey(key)) return -1;
        
        Node node = keyToNode.get(key);

        dll.remove(node);
        dll.addFirst(node);

        return node.val;
    }

    public void put(int key, int val) {
        if(capacity==0) return;

        if(keyToNode.containsKey(key)){
            Node node = keyToNode.get(key);

            node.val = val;

            dll.remove(node);
            dll.addFirst(node);

            return;
        }

        if(keyToNode.size() == capacity) {
            Node lastNode = dll.removeLast();
            keyToNode.remove(lastNode.key);
        }
        
        Node node = new Node(key, val);
        
        keyToNode.put(key, node);
        dll.addFirst(node);
    }
}
