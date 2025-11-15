package LinkedList;

public class SingleLinkedListImpl {
    Node head;
    public SingleLinkedListImpl(){
        this.head = null;
    }
    public Node add(int data){
        this.head = inserNode(head, data);
        return this.head;
    }
    public Node delete(int val){
        this.head = deleteNode(head, val);
        return this.head;
    }
    private Node inserNode(Node head,int data){
        if(head == null){
            return new Node(data);
        }
        Node headNode = head;
        while(headNode!=null && headNode.next!=null){
            headNode = headNode.next;
        }
        headNode.next = new Node(data);
        return head;
    }

    private Node deleteNode(Node head,int val){
        if(head == null){
            return null;
        }
        Node prevNode = null;
        Node currNode = head;
        while(currNode!=null && currNode.data != val){
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = currNode.next;
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currNode = this.head;
        while(currNode != null){
            sb.append(currNode.data).append(" -> ");
            currNode = currNode.next;
        }
        return sb.toString();
    }
}
