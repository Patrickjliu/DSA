import java.util.ArrayList;
import java.util.List;

class Node {
    int value;
    Node left, right;

    
    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

public class BST {
    Node root;

    public BST() {
        root = null;
    }

    public BST(int[] array) {
        root = fromArray(array, 0, array.length - 1);

    }

    private Node fromArray(int[] array, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(array[mid]);

        node.left = fromArray(array, start, mid - 1);

        node.right = fromArray(array, mid + 1, end);

        return node;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node node, int value) {

        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }

        return node;
    }

    public boolean find(int value) {
        return findRec(root, value);
    }

    private boolean findRec(Node node, int value) {

        if (node == null) {
            return false;
        }
        
        if (node.value == value) {
            return true;
        }

        if (value < node.value) {
            return findRec(node.left, value);
        } else {
            return findRec(node.right, value);
        }
    }

    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node node, int value) {

        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.value) {
            node.right = deleteRec(node.right, value);
        } else {

            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.value = minValue(node.right);
            node.right = deleteRec(node.right, node.value);
        }

        return node;
    }

    private int minValue(Node node) {

        int minValue = node.value;
        while (node.left != null) {
            minValue = node.left.value;
            node = node.left;
        }
        return minValue;
    }

    public int[] toArray() {

        List<Integer> result = new ArrayList<>();
        toArrayRec(root, result);

        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }

    private void toArrayRec(Node node, List<Integer> result) {

        if (node == null) {
            return;
        }

        toArrayRec(node.left, result);
        result.add(node.value);
        toArrayRec(node.right, result);
    }

    public static void main(String[] args) {

        BST bst = new BST();
        bst.insert(12);
        bst.insert(22);
        bst.insert(2);
        bst.insert(12);
        System.out.println(bst.find(12));
        System.out.println(bst.find(20));
        int[] inOrderArray = bst.toArray();
        System.out.print("In-order: ");
        for (int i : inOrderArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        bst.delete(10);
        int[] afterDeleteArray = bst.toArray();
        for (int i : afterDeleteArray) {
            System.out.print(i + " ");
        }
    }
}
