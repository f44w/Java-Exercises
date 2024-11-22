package practical7;

public class BinarySearchTree<E extends Comparable<E>> {
    private BTNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    // Search for a value in the BST
    public boolean search(E value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(BTNode<E> node, E value) {
        // Take in the Root node and value to find:
        // Base Case: Value not found:
        if (node == null) { // If there is no root value (ie nothing in the tree) - ret null
            return false;
        }

        // There is a value:
        int compareResult = value.compareTo(node.getValue()); // comparing the value to find to the value in this node we are looking at
        if (compareResult == 0) { // compareTo yields zero if we have the same thing - thus we have found the value we are after
            return true; // Found
        } else if (compareResult < 0) { // Node value is less than - Search left subtree:
            return searchRecursive(node.getLeftChild(), value);
        } else {
            return searchRecursive(node.getRightChild(), value); // Node value is greater than - Search right subtree:
        }
    }

    // Insert a value into the BST
    public void insert(E value) {
        root = insertRecursive(root, value);
    }

    private BTNode<E> insertRecursive(BTNode<E> node, E value) {
        // Base Case: Insert New Node:
        if (node == null) { // No Node element originally - add node in the root position - nothing left or right:
            return new BTNode<>(value, null, null);
        }

        // Comparison and Recursive search process:
        int compareResult = value.compareTo(node.getValue()); // comparing the value to insert to the value in the node we are looking at
        if (compareResult < 0) { // dss
            node.setLeftChild(insertRecursive(node.getLeftChild(), value));
        } else if (compareResult > 0) {
            node.setRightChild(insertRecursive(node.getRightChild(), value));
        }

        // Return unchanged node if the value already exists:
        return node;
    }

    // Delete a value from the BST
    public void delete(E value) {
        root = deleteRecursive(root, value);
    }

    private BTNode<E> deleteRecursive(BTNode<E> node, E value) {
        if (node == null) {
            return null;
        }
        // COMPARISON SECTION:
        int compareResult = value.compareTo(node.getValue());
        if (compareResult < 0) { // value to delete is less than node value - look left for it
            node.setLeftChild(deleteRecursive(node.getLeftChild(), value));
        }else if (compareResult > 0) { // value to delete is greater than node value - look left for it
            node.setRightChild(deleteRecursive(node.getRightChild(), value));
        } else { // Checking if node has only one or no children:
            if (node.getLeftChild() == null) { //
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            // MULTIPLE CHILDREN:
            // Find min value in right subtree (can do max in right) ->
            // Set Root value to that value to ensure BT structure holds ->
            // Delete that value from the tree

            // Take in our root value so changing the value changes the root value:
            node.setValue(findMin(node.getRightChild()).getValue());
            node.setRightChild(deleteRecursive(node.getRightChild(), value));
        }
        return node;
    }

    // Helper method
    private BTNode<E> findMin(BTNode<E> node) {
        // Min value in a tree is the leftmost value in the tree:
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }

    // Method to display the BST (in-order traversal)
    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(BTNode<E> node) {
        if (node != null) {
            inOrderRecursive(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            inOrderRecursive(node.getRightChild());
        }
    }

    public static void main(String[] args) {
        // Creating a binary search tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Inserting elements
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(8);

        // Display tree in in-order traversal (should print sorted order)
        System.out.println("In-order Traversal after insertions:");
        bst.inOrderTraversal();
        System.out.println(); // Newline for clarity

        // Searching elements
        System.out.println("Searching for 7: " + bst.search(7)); // Should return true
        System.out.println("Searching for 20: " + bst.search(20)); // Should return false

        // Deleting elements
        System.out.println("Deleting 3 (leaf node)");
        bst.delete(3);
        System.out.println("In-order Traversal after deleting 3:");
        bst.inOrderTraversal();
        System.out.println();

        System.out.println("Deleting 10 (node with two children)");
        bst.delete(10);
        System.out.println("In-order Traversal after deleting 10:");
        bst.inOrderTraversal();
        System.out.println();

        System.out.println("Deleting 15 (node with one child)");
        bst.delete(15);
        System.out.println("In-order Traversal after deleting 15:");
        bst.inOrderTraversal();
        System.out.println();



    }
}
