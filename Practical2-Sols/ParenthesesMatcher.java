package practical2;

import java.util.Scanner;


public class ParenthesesMatcher {
    public static boolean isMatchingPair(char opening, char closing) {
        // Matching pairs of parentheses, including curly braces
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }

    public static boolean checkParentheses(String str) {
        LinkedStack<Character> stack = new LinkedStack<>();

        // Traverse the string to check for matching parentheses
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // Push opening parentheses onto the stack
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            }
            // Check for closing parentheses
            else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                if (stack.isEmpty()) {
                    return false; // No opening parenthesis to match
                }
                char topChar = stack.pop();
                if (!isMatchingPair(topChar, currentChar)) {
                    return false; // Mismatch found
                }
            }
            // Ignore all other characters
        }

        // After traversing, the stack should be empty if all parentheses match
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string from the user
        System.out.print("Enter a string with parentheses: ");
        String input = scanner.nextLine();

        // Check if the parentheses in the string are balanced
        if (checkParentheses(input)) {
            System.out.println("Parentheses are balanced.");
        } else {
            System.out.println("Parentheses are not balanced.");
        }

        scanner.close();
    }
}


