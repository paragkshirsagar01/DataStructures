package CircularQueue;

class Queue{
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    Node front = null;
    Node rear = null;
    int capacity;
    int size = 0;
    public boolean isEmpty(){
        return front == null;
    }
    public boolean isFull(){
        return size == capacity;
    }
    public boolean enqueue(int value){
        if(isFull()){
            return false;
        }
        Node newNode = new Node(value);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
            newNode.next = front;
        }else{
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
        size++;
        return true;
    }
    public boolean dequeue(){
        if(isEmpty()){
            return false;
        }
        if(front == rear){
            front = null;
            rear = null;
        }else{
            front = front.next;
            rear.next = front;
        }
        size -- ;
        return true;
    }
}

public class CircularQueue {
    public static void main(String[] args) {
        System.out.println("Circular Queue Implementation");
    }
}
