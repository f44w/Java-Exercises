package practical2;

import java.util.EmptyStackException;
import java.util.Scanner;

public class StackApp {
    public static void main(String[] args) {
        StackADT<String> stack = new LinkedStack<>();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\nEnter an operation from the following:");
            System.out.println("1 - Push a string onto the stack");
            System.out.println("2 - Pop a string from the stack");
            System.out.println("3 - Get Size of stack");
            System.out.println("4 - Get Top element");
            System.out.println("5 - Check if stack is Empty");
            System.out.println("6 - Traverse the stack");
            System.out.println("7 - Exit");

            int op = scanner.nextInt();
            scanner.nextLine();

            switch(op){
                case 1:
                    System.out.println("Enter a string to push to stack: ");
                    stack.push(scanner.nextLine());
                    System.out.println("Pushed to stack!");
                    break;

                case 2:
                    try{
                        String itemRemoved = stack.pop();
                        System.out.println("Pop from stack: "+itemRemoved);
                    }
                    catch(EmptyStackException e){
                        System.out.println("Empty stack! Nothing to Pop!");
                    }
                    break;

                case 3:
                    System.out.println("Stack size is: " + stack.size());
                    break;

                case 4:
                    try{
                        String top = stack.getTop();
                        System.out.println("Top element: "+top);
                    }
                    catch(EmptyStackException e){
                        System.out.println("Empty stack! Nothing to get!");
                    }
                    break;

                case 5:
                    if(stack.isEmpty()){
                        System.out.println("Stack is Empty!");
                    }else{
                        System.out.println("Stack is not Empty!");
                    }
                    break;

                case 6:
                    try{
                        System.out.println("Traversing the stack:");
                        stack.traverse();
                    }
                    catch (EmptyStackException e){
                        System.out.println("Empty stack! Nothing to get!");
                    }
                    break;

                case 7:
                    System.out.println("Quitting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input. Try again!");
            }
        }
    }
}
