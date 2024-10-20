package practical2;
import java.util.Scanner;


public class TestStackApp {
    public static void main(String[] args) {
        // Declare a variable of type Stack (using the interface type for good practice)
        LinkedStack<String> stack = new LinkedStack<>(); // Using LinkedStack class

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1: Push a string onto the stack");
            System.out.println("2: Pop the top string from the stack");
            System.out.println("3: Peek at the top string of the stack");
            System.out.println("4: Check if the stack is empty");
            System.out.println("5: Get the size of the stack");
            System.out.println("6: Traverse the stack");
            System.out.println("7: Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character after nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter a string to push: ");
                    String item = scanner.nextLine();
                    stack.push(item);
                    System.out.println("Pushed \"" + item + "\" onto the stack.");
                    break;

                case 2:
                    try {
                        String removedItem = stack.pop();
                        System.out.println("Popped \"" + removedItem + "\" from the stack.");
                    } catch (EmptyStackException e) {
                        System.out.println("Cannot pop: The stack is empty.");
                    }
                    break;

                case 3:
                    try {
                        String topItem = stack.getTop();
                        System.out.println("Top item is: \"" + topItem + "\"");
                    } catch (EmptyStackException e) {
                        System.out.println("Cannot peek: The stack is empty.");
                    }
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        System.out.println("The stack is empty.");
                    } else {
                        System.out.println("The stack is not empty.");
                    }
                    break;

                case 5:
                    System.out.println("The size of the stack is: " + stack.size());
                    break;

                case 6:
                    stack.traverse();
                    break;

                case 7:
                    quit = true;
                    System.out.println("Quitting the application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
