package StacksAndQueues.ImpProblems;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    
    class Node {
        Node prev, next;
        int key, val, freq;
    
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
    
    class DoublyLL {
        //All the key value pairs will get stored in this
        Node head, tail;
        int size;
    
        public DoublyLL () {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
    
            head.next = tail;
            tail.prev = head;
    
            size = 0;
        }
    
        public void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
    
            head.next.prev = node;
            head.next = node;
    
            size++;
        }
    
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
    
            size--;
        }
    
        public Node removeLast(){
            Node lastNode = tail.prev;
    
            lastNode.prev.next = tail;
            tail.prev = lastNode.prev;
    
            size--;
            return lastNode;
        }
    } 

    private int capacity, minFreq;
    private Map<Integer, Node> keyToNode;
    private Map<Integer, DoublyLL> freqToList;

    public LFUCache (int capacity) {
        this.capacity = capacity;
        minFreq = 0;

        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
    }

    public int get(int key) {
        if(!keyToNode.containsKey(key)) return -1;

        Node node = keyToNode.get(key);
        updateFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(keyToNode.containsKey(key)){
            Node node = keyToNode.get(key);

            node.val = value;
            updateFreq(node);
            return;
        }

        if(keyToNode.size()==capacity){
            DoublyLL leastFreqList = freqToList.get(minFreq);

            Node leastFreqNode = leastFreqList.removeLast();
            keyToNode.remove(leastFreqNode.key);
        }

        minFreq = 1;
        Node node = new Node(key, value);
        keyToNode.put(key, node);
        
        DoublyLL freqLl = freqToList.getOrDefault(minFreq, new DoublyLL());
        freqLl.addFirst(node);
        freqToList.put(minFreq, freqLl);
    }

    public void updateFreq(Node node) {
        int oldFreq = node.freq;

        DoublyLL oldList = freqToList.get(oldFreq);
        oldList.remove(node);

        if(oldFreq==minFreq && oldList.size==0) minFreq++;

        node.freq++;

        DoublyLL newList = freqToList.getOrDefault(node.freq, new DoublyLL());
        newList.addFirst(node);
        freqToList.put(node.freq, newList);
    }
}
