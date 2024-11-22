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
        if (node == null) {
            return false; // Value not found
        }
        int compareResult = value.compareTo(node.getValue());
        if (compareResult == 0) {
            return true; // Value found
        } else if (compareResult < 0) {
            return searchRecursive(node.getLeftChild(), value); // Search in left subtree
        } else {
            return searchRecursive(node.getRightChild(), value); // Search in right subtree
        }
    }

    // Insert a value into the BST
    public void insert(E value) {
        root = insertRecursive(root, value);
    }

    private BTNode<E> insertRecursive(BTNode<E> node, E value) {
        if (node == null) {
            return new BTNode<>(value, null, null); // Insert new node
        }
        int compareResult = value.compareTo(node.getValue());
        if (compareResult < 0) {
            node.setLeftChild(insertRecursive(node.getLeftChild(), value));
        } else if (compareResult > 0) {
            node.setRightChild(insertRecursive(node.getRightChild(), value));
        }
        return node; // Return unchanged node if value already exists
    }

    // Delete a value from the BST
    public void delete(E value) {
        root = deleteRecursive(root, value);
    }

    private BTNode<E> deleteRecursive(BTNode<E> node, E value) {
        if (node == null) {
            return null; // Value not found
        }

        int compareResult = value.compareTo(node.getValue());
        if (compareResult < 0) {
            node.setLeftChild(deleteRecursive(node.getLeftChild(), value));
        } else if (compareResult > 0) {
            node.setRightChild(deleteRecursive(node.getRightChild(), value));
        } else {
            // Node with only one child or no child
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            node.setValue(findMin(node.getRightChild()).getValue());
            // Delete the inorder successor
            node.setRightChild(deleteRecursive(node.getRightChild(), node.getValue()));
        }

        return node;
    }

    private BTNode<E> findMin(BTNode<E> node) {
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
