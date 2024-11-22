package Practical6;

public class ExpressionTree extends BTree<String> {

    public ExpressionTree(BTNode<String> root) {
        super(root);
    }

    // Method to evaluate the expression tree
    public int evaluate() {
        return evaluateHelper(root);
    }

    private int evaluateHelper(BTNode<String> node) {
        if (node == null) {
            return 0;
        }

        // If it's a leaf node, return its integer value
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            try{
                return Integer.parseInt(node.getValue());
            }catch(NumberFormatException e){
                throw new IllegalArgumentException("Node cannot be null");
            }
        }

        // Recursively evaluate left and right subtrees
        int leftEval = evaluateHelper(node.getLeftChild());
        int rightEval = evaluateHelper(node.getRightChild());

        // Apply the operator at this node
        switch (node.getValue()) {
            case "+":
                return leftEval + rightEval;
            case "-":
                return leftEval - rightEval;
            case "*":
                return leftEval * rightEval;
            case "/":
                if (rightEval != 0) {
                    return leftEval / rightEval;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + node.getValue());
        }
    }

    // Main method to test the expression tree
    public static void main(String[] args) {
        // Constructing an expression tree for: 3 + ((5 + 9) * 2)
        BTNode<String> nodePlusInner = new BTNode<>("+", new BTNode<>("5"), new BTNode<>("9"));
        BTNode<String> nodeMultiply = new BTNode<>("*", nodePlusInner, new BTNode<>("2"));
        BTNode<String> root = new BTNode<>("+", new BTNode<>("3"), nodeMultiply);

        ExpressionTree expressionTree = new ExpressionTree(root);

        System.out.println("Inorder Traversal:");
        expressionTree.inorderTraversal();

        System.out.println("Preorder Traversal:");
        expressionTree.preorderTraversal();

        System.out.println("Postorder Traversal:");
        expressionTree.postorderTraversal();

        System.out.println("Evaluated Expression Result:");
        System.out.println(expressionTree.evaluate());
    }
}
