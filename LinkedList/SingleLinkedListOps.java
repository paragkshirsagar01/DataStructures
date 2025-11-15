package LinkedList;

public class SingleLinkedListOps {
    public static void main(String[] args) {
        SingleLinkedListImpl list = new SingleLinkedListImpl();
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.toString());
        list.delete(3);
        System.out.println(list.toString());
    }
}
