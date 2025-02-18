import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Integer;
import java.lang.Double;

public class DoublyLinkedListDriver {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java CommandProcessor <filename>");
            return;
        }
        Scanner userScanner = new Scanner(System.in);
        String fileName = args[0];
        DoublyLinkedList list = null;
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            
            try {
                Scanner scanner = new Scanner(new File(fileName));
                String choice = "";
                System.out.print("Enter List Type (i - int, d - double, s - std:string): ");
                choice = userScanner.nextLine().trim();
                switch(choice) {
                    case "i": 
                        list = new DoublyLinkedList<Integer>();
                        while(fileScanner.hasNextInt()) {
                            list.insertItem(fileScanner.nextInt());
                        }
                        fileScanner.close();
                        break;
                    case "d":
                        list = new DoublyLinkedList<Double>();
                        while(fileScanner.hasNextDouble()) {
                            list.insertItem(fileScanner.nextDouble());
                        }
                        fileScanner.close();
                        break;
                    case "s":
                        list = new DoublyLinkedList<String>();
                        while(fileScanner.hasNext()) {
                            list.insertItem(fileScanner.next());
                        }
                        fileScanner.close();
                        break;
                }
                scanner.close();
            } catch (IOException e) {
                System.out.println("file name is invalid, try again.");
            }

            System.out.println("Commands:\n" +
            "(i) - Insert value\n" +
            "(d) - Delete value\n" +
            "(s) - Search value\n" +
            "(n) - Print next iterator value\n" +
            "(r) - Reset iterator\n" +
            "(a) - Delete alternate nodes\n" +
            "(m) - Merge lists\n" +
            "(t) - Find intersection\n" +
            "(p) - Print list\n" +
            "(l) - Print length\n" +
            "(q) - Quit program");
            String input = "";

            do {
                try { 
                    System.out.print("Enter a command: ");
                    input = userScanner.nextLine().trim();
                    int tempInt;
                    switch (input) {
                        case "i":
                            System.out.print("Enter a number to insert: ");
                            tempInt = userScanner.nextInt();
                            System.out.print("Original List: ");
                            list.printList();
                            list.insertItem(new ItemType(tempInt));
                            System.out.print("New List: ");
                            list.printList();
                            userScanner.nextLine();
                            break;
                        case "d":
                            System.out.print("Enter a Number to Delete: ");
                            tempInt = userScanner.nextInt();
                            System.out.print("Original List: ");
                            list.printList();
                            list.deleteItem(new ItemType(tempInt));
                            System.out.print("New List: ");
                            list.printList();
                            userScanner.nextLine();
                            break;
                        case "s":
                            
                        case "n":
                            
                        case "r":

                        case "a":
                            System.out.print("Original List: ");
                            list.printList();
                            list.deleteAlternateNodes();
                            System.out.print("Modified List: ");
                            list.printList();
                            break;
                        case "m":
                            SortedLinkedList list1 = getNewSortedList();
                            System.out.print("The list 1: ");
                            list.printList();
                            System.out.print("The list 2: ");
                            list1.printList();
                            list.mergeList(list1);
                            break;
                        case "t":
                            SortedLinkedList list2 = getNewSortedList();
                            System.out.print("The list 1: ");
                            list.printList();
                            System.out.print("The list 2: ");
                            list2.printList();
                            System.out.print("Intersection of lists:");
                            list.intersection(list2);
                            break;
                        case "p":
                            System.out.print("The list is: ");
                            list.printList();
                            break;
                        case "l":
                            System.out.println("The length of the list is: " + list.getLength());
                            break;
                        case "q":
                            System.out.println("Quitting program...");
                            break;
                        default:
                            System.out.println("Invalid command. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, try again.");
                    userScanner.nextLine();
                    continue;
                }
            } while (!input.equals("q"));
                userScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("bad file name");
            } 
        }
    }
    /**
     * Creates a new `SortedLinkedList` object and populates it with integers provided
     * by the user.
     * @return A newly created and populated `SortedLinkedList` object.
     
    public static SortedLinkedList getNewSortedList() {
        Scanner scanner = new Scanner(System.in);
        SortedLinkedList newList = new SortedLinkedList();
    
        System.out.print("Enter the length of the new list: ");
        int newListLength;
        while (true) {
            if (scanner.hasNextInt()) {
                newListLength = scanner.nextInt();
                if (newListLength > 0) {
                    break;
                }
                System.out.println("Length must be positive. Try again.");
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }
    
        scanner.nextLine();
    
        System.out.print("Enter the numbers: ");
        String line = scanner.nextLine();
        String[] values = line.split("\\s+");
    
        if (values.length != newListLength) {
            System.out.println("The number of values entered does not match the specified length.");
            return newList;
        }
    
        for (String value : values) {
            try {
                int intValue = Integer.parseInt(value);
                newList.insertItem(new ItemType(intValue));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + value + " is not an integer.");
            }
        }
    
        return newList;
    } */


