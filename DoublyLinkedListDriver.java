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
        int type = 0;
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            
            try {
                Scanner scanner = new Scanner(new File(fileName));
                String choice = "";
                System.out.print("Enter List Type (i - int, d - double, s - std:string): ");
                choice = userScanner.nextLine().trim();
                switch(choice) {
                    case "i": 
                        type = 1;
                        list = new DoublyLinkedList<Integer>();
                        while(fileScanner.hasNextInt()) {
                            list.insertItem(fileScanner.nextInt());
                        }
                        fileScanner.close();
                        break;
                    case "d":
                        type = 2;
                        list = new DoublyLinkedList<Double>();
                        while(fileScanner.hasNextDouble()) {
                            list.insertItem(fileScanner.nextDouble());
                        }
                        fileScanner.close();
                        break;
                    case "s":
                        type = 3;
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
            "(p) - Print list\n" +
            "(l) - Length\n" +
            "(t) - Print reverse\n" +
            "(r) - Reverse list\n" +
            "(b) - Delete Subsection\n" +
            "(s) - Swap Alternate\n" +
            "(q) - Quit program");
            String input = "";

            do {
                try { 
                    System.out.print("Enter a command: ");
                    input = userScanner.nextLine().trim();
                    switch (input) {
                        case "i":
                            System.out.print("Enter a number to insert: ");
                            Comparable toInsert = getValue(userScanner,type);
                            System.out.print("Original List: ");
                            list.print();
                            list.insertItem(toInsert);
                            System.out.print("New List: ");
                            list.print();
                            userScanner.nextLine();
                            break;
                        case "d":
                            System.out.print("Enter a Number to Delete: ");
                            Comparable toDelete = getValue(userScanner,type);
                            System.out.print("Original List: ");
                            list.print();
                            list.deleteItem(toDelete);
                            System.out.print("New List: ");
                            list.print();
                            userScanner.nextLine();
                            break;
                        case "p":
                            System.out.print("The list is: ");
                            list.print();
                            break;    
                        case "l":
                            System.out.println("The length of the list is: " + list.length());
                            break;
                        case "t":
                            System.out.print("The reverse list: ");
                            list.printReverse();
                            break;  
                        case "r":
                            System.out.print("The original list: ");
                            list.print();
                            System.out.print("The reversed list: ");
                            list.reverseList();
                            list.print();
                            break;
                        case "b":
                            System.out.print("Enter the lower bound: ");
                            Comparable lowerBound = getValue(userScanner, type);
                            System.out.print("Enter the upper bound: ");
                            Comparable upperBound = getValue(userScanner, type);
                            System.out.print("The original list: ");
                            list.print();
                            System.out.print("The modified list: ");
                            list.deleteSubsection(lowerBound, upperBound);
                            list.print();
                            System.out.print("The reverse list: ");
                            list.printReverse();
                            break;
                        case "s":
                            System.out.print("The original list: ");
                            list.print();
                            System.out.print("The modified list: ");
                            list.swapAlternate();
                            System.out.print("The reverse list: ");
                            list.printReverse();
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

        @SuppressWarnings("unchecked")
        public static <T> T getValue(Scanner s, int c) {
            if (c == 1) {
                return (T) Integer.valueOf(s.nextInt());  
            } else if (c == 2) {
                return (T) Double.valueOf(s.nextDouble());  
            } else if (c == 3) {
                return (T) s.next(); 
            }
            return null;  
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


