package Practical6;

public class ExpressionTree extends BTree<String> {
    public ExpressionTree(BTree<String> root) {
        super(root);
    }

    // Method to evaluate the expression tree:
    public int evaluate(){
        return evaluateHelper(root);
    }

    private int evaluateHelper(BTree<String> root){

        return 0;
    }
}
