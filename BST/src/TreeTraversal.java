import java.util.ArrayList;
import java.util.List;

// From BST.java
class Node {
    int value;
    Node left, right;


    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class TreeTraversal {
    public List<Integer> preOrder(Node root) {

        List<Integer> result = new ArrayList<>();
        preOrderRec(root, result);
        return result;
    }

    private void preOrderRec(Node node, List<Integer> result) {
        
        if (node == null) {
            return;
        }

        result.add(node.value);
        preOrderRec(node.left, result);
        preOrderRec(node.right, result);
    }

    public List<Integer> postOrder(Node root) {

        List<Integer> result = new ArrayList<>();
        postOrderRec(root, result);
        return result;
    }

    private void postOrderRec(Node node, List<Integer> result) {

        if (node == null) {
            return;
        }

        postOrderRec(node.left, result);
        postOrderRec(node.right, result);
        result.add(node.value);
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        
        TreeTraversal traversal = new TreeTraversal();
        
        List<Integer> preOrderList = traversal.preOrder(root);
        System.out.println("Pre-order " + preOrderList);
        
        List<Integer> postOrderList = traversal.postOrder(root);
        System.out.println("Post-order " + postOrderList);

    }
}