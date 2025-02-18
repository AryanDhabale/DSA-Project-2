public class DoublyLinkedListDriver {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> test = new DoublyLinkedList<>();
        test.insertItem(1);
        test.insertItem(2);
        test.insertItem(3);
        test.insertItem(4);
        test.insertItem(5);
        test.insertItem(6);
        test.insertItem(7);
        test.insertItem(8);
        test.print();
        test.reverseList();
        test.print();
    }   
}
