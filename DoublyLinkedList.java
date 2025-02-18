import java.lang.Comparable;
import java.util.Stack;

public class DoublyLinkedList<T extends Comparable<T>> {

    private NodeType<T> head;
    private NodeType<T> currentPos;

    public DoublyLinkedList(){

    };

    public void insertItem(T item) {
        NodeType<T> addedNode = new NodeType<T>(item);
        //Inserts at the head if list is empty or is before first item
        if (head == null || head.info.compareTo(item) >= 0) {
            if (head != null && head.info.compareTo(item) == 0) {
                System.out.println("Sorry. You cannot insert the duplicate item");
                return;
            }
            head = new NodeType<T>(item, head);
            return;
        }
        //Checks for each element in list to find an item that is greater than item, and
        //inserts right before it
        currentPos = head;
        while (currentPos.next != null) {
            if (currentPos.next.info.compareTo(item) == 0) {
                System.out.println("Sorry. You cannot insert the duplicate item");
                return;
            }
            if (currentPos.next.info.compareTo(item) > 0) {
                addedNode.next = currentPos.next;
                currentPos.next = addedNode;
                addedNode.back = currentPos;
                addedNode.next.back = addedNode;
                return;
            }
            currentPos = currentPos.next;
        }       
        //If no item greater than "item" is found, insert at the end of the list
        currentPos.next = addedNode;
        addedNode.back = currentPos;
        resetList();
    }

    public void deleteItem(T item) {
        if (head == null) {
            System.out.println("You cannot delete from an empty list");
            return;
        } 
        // Remove element from head if the item is at head
        if (head.info.compareTo(item) == 0) {
            head = head.next;
            if (head != null) {
                head.back = null;
            }
            return;
        }
        currentPos = head;
        while (currentPos != null) {
            if (currentPos.info.compareTo(item) == 0) {
                // If currentPos is not the tail, update the next node's back pointer.
                if (currentPos.next != null) {
                    currentPos.next.back = currentPos.back;
                }
                // Update the previous node's next pointer.
                currentPos.back.next = currentPos.next;
                currentPos.back = null;
                currentPos.next = null;
                return;
            }
            currentPos = currentPos.next;
        }
        System.out.println("Item not found");
        resetList();
    }

    public int length() {
        currentPos = head;
        int count = 0;
        while (currentPos.next != null) {
            count++;
            currentPos = currentPos.next;
        }
        return count;
    }

    public void print() {
        currentPos = head;
        while (currentPos != null) {
            System.out.println(currentPos.info + " ");
            currentPos = currentPos.next;
        }
        System.out.println();
    }

    public void printReverse() {
        currentPos = head;
        Stack<T> reverse = new Stack<>();
        while (currentPos != null) {
            reverse.push(currentPos.info);
            currentPos = currentPos.next;
        }
        while (!reverse.isEmpty()) {
            System.out.print(reverse.pop() + " ");
        }
        System.out.println();
    }

    //DESTRUCTIVE FUNCTIONS
    //After these functions are called, the list is no longer sorted, and the order is broken
    //The program should stop after the output of these functions are printed
    public void deleteSubsection(T lower, T upper) {
        if (head == null) return;
        
        while (head != null && head.info.compareTo(lower) >= 0 && head.info.compareTo(upper) <= 0) {
            head = head.next;
            if (head != null) {
                head.back = null; 
            }
        }

        currentPos = head;
        while (currentPos != null && currentPos.next != null) {
            if (currentPos.next.info.compareTo(lower) >= 0 && currentPos.next.info.compareTo(upper) <= 0) {
                currentPos.next = currentPos.next.next;
                if (currentPos.next != null) {
                    currentPos.next.back = currentPos;
                }
            } else {
                currentPos = currentPos.next;
            }
        }
        
    }

    public void reverseList() {
        if (head == null) return;

        NodeType<T> temp = null;
        currentPos = head;

        while (currentPos != null) {
            temp = currentPos.next;
            currentPos.next = currentPos.back;
            currentPos.back = temp;

            currentPos = currentPos.back;
            
            if (temp != null) {
                head = temp;
            }
        }
    }
        
        



    public void swapAlternate() {
        if (head == null) return;

        currentPos = head;
        NodeType<T> temp;

        while (currentPos != null && currentPos.next != null) {
            temp = currentPos.next;

            if (currentPos.back != null) {
                currentPos.back.next = temp;
            } else {
                head = temp;
            }

            if (temp.next != null) {
                temp.next.back = currentPos;
            }

            currentPos.next = temp.next;
            temp.next = currentPos;
            temp.back = currentPos.back;
            currentPos.back = temp;

            currentPos = currentPos.next;
        }
    }
    
    //HELPER METHODS
    //Methods that we added for our own convenience
    public void resetList() {
        currentPos = null;
    }
}
