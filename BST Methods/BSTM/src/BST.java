import java.util.*;

public class BST {
    static class TreeNode {

        int val;
        TreeNode left, right;
        
        TreeNode(int val) {

            this.val = val;
            this.left = null;
            this.right = null;

        }


    }


    public static void main(String[] args) {

        BST bst = new BST();
        
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);

        // Test getHeight
        System.out.println("Height " + bst.getHeight(root));
        
        // Test isBalanced
        System.out.println("Balanced " + bst.isBalanced(root));
        
        // Test layerOrderTraversal
        System.out.println("LOT " + bst.layerOrderTraversal(root));
        
        // Test isValidBST
        System.out.println("Is Valid " + bst.isValidBST(root, null, null));

        // Test balance
        System.out.println("Balanced Tree");
        TreeNode balancedRoot = bst.balance(root);
        bst.printTree(balancedRoot);
    }


    public int getHeight(TreeNode node) {
        int result = 0;
        if (node == null) {
            return result;
        }
        result = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return result;
    }

    public void printTree(TreeNode node) {
        printTreeHelper(node, 0);
    }

    private void printTreeHelper(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < level; i++) 
        {
            System.out.print("\t");
        }
        System.out.println(node.val);

        printTreeHelper(node.left, level + 1);
        printTreeHelper(node.right, level + 1);
    }

    public boolean isBalanced(TreeNode node) {
        return checkHeight(node) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public List<Integer> layerOrderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

    public TreeNode balance(TreeNode root) {

        List<TreeNode> nodes = new ArrayList<>();
        storeInOrder(root, nodes);

        return buildBalancedTree(nodes, 0, nodes.size() - 1);
    }

    private void storeInOrder(TreeNode node, List<TreeNode> nodes) {

        if (node == null) {
            return;
        }

        storeInOrder(node.left, nodes);
        nodes.add(node);
        storeInOrder(node.right, nodes);
    }

    private TreeNode buildBalancedTree(List<TreeNode> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        TreeNode root = nodes.get(mid);
        
        root.left = buildBalancedTree(nodes, start, mid - 1);
        root.right = buildBalancedTree(nodes, mid + 1, end);
        
        return root;
    }

    public boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
