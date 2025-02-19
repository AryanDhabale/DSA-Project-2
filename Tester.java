class Tester {
    public static void main(String args[]) {
            DoublyLinkedList<Integer> test = new DoublyLinkedList<>();
            test.insertItem(15);
            test.insertItem(4);
            test.insertItem(25);
            test.insertItem(12);
            test.insertItem(50);
            test.insertItem(22);
            test.insertItem(10);
            test.insertItem(35);
            test.insertItem(18);
            test.insertItem(24);
    
            test.print();
            test.reverseList();
            test.print();
    }
}