package practical2;

import java.util.Scanner;
import java.util.Stack;

public class ParentheseMatcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string of parentheses: ");
        String userString = scanner.nextLine();
        char[] charArray = userString.toCharArray();
        System.out.println(isBalanced(charArray));
        scanner.close();
    }
    private static boolean isBalanced(char[] X){
        // init empty stack:
        StackADT<String> myStack = new LinkedStack<>();
        for(int i=0; i<X.length; i++){
            // if X[i] equals an opening bracket:
            if(X[i]=='('||X[i]=='['||X[i]=='{'){
                myStack.push(String.valueOf(X[i]));
                // if X[i] equals a closing bracket:
            }else if(X[i]==')'||X[i]==']'||X[i]=='}'){
                // Here if we have found a closing bracket:
                if(myStack.isEmpty()){
                    // Nothing to match with, return false
                    return false;
                    // Stack not empty, compare X[i] with our top stack element
                }else{
                    switch(myStack.pop()){
                        case "(":
                            if(X[i] == ')');
                            break;
                        case "[":
                            if(X[i] == ']');
                            break;

                        case "{":
                            if(X[i] == '}');
                            break;

                        default:
                            return false;

                    }
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }
}
