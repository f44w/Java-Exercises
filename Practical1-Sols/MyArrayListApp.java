package practical1;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class MyArrayListApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyArrayList<String> list = new MyArrayList<>(); // Create a MyArrayList to store Strings

        int choice;
        do {
            System.out.println("\nOptions:");
            System.out.println("1: Add an item at position i");
            System.out.println("2: Remove the ith item");
            System.out.println("3: Get the ith item");
            System.out.println("4: Check if the list is empty");
            System.out.println("5: Get the size of the list");
            System.out.println("6: Display all items in the list");
            System.out.println("7: Search for an item in the list");
            System.out.println("8: Quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to add: ");
                    String itemToAdd = sc.nextLine();
                    System.out.print("Enter the position (index) to add the item: ");
                    int indexToAdd = sc.nextInt();
                    try {
                        list.insert(indexToAdd, itemToAdd);
                        System.out.println("Item added successfully.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index. Please try again.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the position (index) to remove the item: ");
                    int indexToRemove = sc.nextInt();
                    try {
                        String removedItem = list.delete(indexToRemove);
                        System.out.println("Removed item: " + removedItem);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid index. Please try again.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the position (index) to get the item: ");
                    int indexToGet = sc.nextInt();
                    try {
                        String item = list.get(indexToGet);
                        System.out.println("Item at index " + indexToGet + ": " + item);
                    } catch (IndexOutOfBoundsException | NoSuchElementException e) {
                        System.out.println("Invalid index or list is empty. Please try again.");
                    }
                    break;

                case 4:
                    if (list.isEmpty()) {
                        System.out.println("The list is empty.");
                    } else {
                        System.out.println("The list is not empty.");
                    }
                    break;

                case 5:
                    System.out.println("Size of the list: " + list.size());
                    break;

                case 6:
                    System.out.println("Items in the list:");
                    list.display();
                    break;

                case 7:
                    System.out.print("Enter the item to search for: ");
                    String itemToSearch = sc.nextLine();
                    int searchResult = list.search(itemToSearch);
                    if (searchResult != -1) {
                        System.out.println("Item found at index: " + searchResult);
                    } else {
                        System.out.println("Item not found in the list.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting the application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        } while (choice != 8);

        sc.close();
    }
}
