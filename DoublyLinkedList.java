import java.lang.Comparable;

public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head;
    private NodeType<T> currentPos;

    public DoublyLinkedList(){};

    public void insertItem(T item){
        //Inserts at the head if list is empty or is before first item
        if (head == null || head.getInfo().compareTo(item) >= 0) {
            if (head != null && head.getInfo().compareTo(item) == 0) {
                System.out.println("Sorry. You cannot insert the duplicate item");
                return;
            }
            head = new NodeType<T>(item, head);
            return;
        }
        //Checks for each element in list to find an item that is greater than item, and
        //inserts right before it
        currentPos = head;
        while (currentPos.getNext() != null) {
            if (currentPos.getNext().getInfo().compareTo(item) == 0) {
                System.out.println("Sorry. You cannot insert the duplicate item");
                resetList();
                return;
            }
            if (currentPos.getNext().getInfo().compareTo(item) > 0) {
                NodeType<T> addedNode = new NodeType<T>(item);
                addedNode.setNext(currentPos.getNext());
                currentPos.setNext(addedNode);
                addedNode.setBack(currentPos);
                addedNode.getNext().setBack(addedNode);
                resetList();
                return;
            }
            currentPos = currentPos.getNext();
        }       
        //If no item greater than "item" is found, insert at the end of the list
        currentPos.setNext(new NodeType<T>(item,null));
         resetList();
    }

    public void deleteItem(T item) {
        if (head == null) {
            System.out.println("You cannot delete from an empty list");
            return;
        } 
        // Remove element from head if the item is at head
        if (head.getInfo().compareTo(item) == 0) {
            head = head.getNext();
            if (head != null) {
                head.setBack(null);
            }
            return;
        }
        currentPos = head;
        while (currentPos != null) {
            if (currentPos.getInfo().compareTo(item) == 0) {
                // If currentPos is not the tail, update the next node's back pointer.
                if (currentPos.getNext() != null) {
                    currentPos.getNext().setBack(currentPos.getBack());
                }
                // Update the previous node's next pointer.
                currentPos.getBack().setNext(currentPos.getNext());
                currentPos.setBack(null);
                currentPos.setNext(null);
                resetList();
                return;
            }
            currentPos = currentPos.getNext();
        }
        System.out.println("Item not found");
        resetList();
    }

    public int length(){
        currentPos = head;
        int count = 0;
        while (currentPos.getNext() != null) {
            count++;
            currentPos = currentPos.getNext();
        }
        return count;
    };

    public void print(){
        return;
    };

    public void printReverse(){
        return;
    };

    //DESTRUCTIVE FUNCTIONS
    //After these functions are called, the list is no longer sorted, and the order is broken
    //The program should stop after the output of these functions are printed
    public void deleteSubsection(T lower, T upper){
        return;
    };

    public void reverseList(){
        return;
    };

    public void swapAlternate(){
        return;
    };
    
    //HELPER METHODS
    //Methods that we added for our own convenience
    public void resetList(){
        currentPos = null;
    }
}
