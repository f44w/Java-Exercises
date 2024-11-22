package Practical6;

public class BTree<E> {
    protected BTNode<E> root;

    public BTree() {
        root = null;
    }

    public BTree(BTNode<E> root) {
        this.root = root;
    }

    public void inorderTraversal() {
        inorderHelper(root);
        System.out.println();
    }

    private void inorderHelper(BTNode<E> node) {




    }

    public void preorderTraversal() {
        preorderHelper(root);
        System.out.println();
    }

    private void preorderHelper(BTNode<E> node) {





    }

    public void postorderTraversal() {
        postorderHelper(root);
        System.out.println();
    }

    private void postorderHelper(BTNode<E> node) {






    }

    // Main method to test the traversals
    public static void main(String[] args) {
        // Creating nodes
        BTNode<Integer> node1 = new BTNode<>(1, null, null);
        BTNode<Integer> node2 = new BTNode<>(2, null, null);
        BTNode<Integer> node3 = new BTNode<>(3, null, null);
        BTNode<Integer> node4 = new BTNode<>(4, null, null);
        BTNode<Integer> node5 = new BTNode<>(5, null, null);

        // Constructing the tree
        node2.setLeftChild(node1);        // 2 -> 1
        node2.setRightChild(node3);       // 2 -> 3
        node3.setRightChild(node5);       // 3 -> 5
        node3.setLeftChild(node4);        // 3 -> 4

        BTree<Integer> tree = new BTree<>(node2); // Root is node 2

        System.out.println("Inorder Traversal:");
        tree.inorderTraversal();

        System.out.println("Preorder Traversal:");
        tree.preorderTraversal();

        System.out.println("Postorder Traversal:");
        tree.postorderTraversal();
    }
}
