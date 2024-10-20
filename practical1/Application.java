package practical1;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ListADT<String> myList = new MyArrayList<>();

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation; 'quit', 'delete', 'insert', " +
                    "'get', 'check', 'size', 'display', 'search' :");
            // Take operation given by user:
            String userOp = scanner.nextLine();

            switch (userOp) {
                case "quit":
                    // Works
                    System.out.println("Qutting...");
                    System.exit(0);
                    break;

                case "delete":
                    System.out.println("Enter index to be deleted: ");
                    int a = scanner.nextInt();
                    myList.delete(a);
                    System.out.println("Element deleted!");
                    break;

                case "insert":
                    System.out.println("Enter value to insert, then, on a newline, the index to insert to: ");
                    String w = scanner.nextLine();
                    int b = scanner.nextInt();
                    myList.insert(b, w);
                    break;

                case "get":
                    System.out.println("Enter index to get: ");
                    int c = scanner.nextInt();
                    myList.get(c);
                    System.out.println(myList.get(c));
                    break;

                case "check":
                    System.out.println("Checking...");
                    System.out.println("List empty is: " + myList.isEmpty());
                    break;

                case "size":
                    System.out.println("The size is: " + myList.size());
                    break;

                case "display":
                    myList.display();
                    System.out.println("");
                    break;

                case "search":
                    System.out.println("Enter a value to search for: ");
                    String s = scanner.nextLine();
                    System.out.println("Searching...");
                    if (myList.search(s) == -1) {
                        System.out.println("Element not found");
                    } else {
                        System.out.println("Element found at index: " + myList.search(s));
                    }
                    break;
            }
        }
    }
}

