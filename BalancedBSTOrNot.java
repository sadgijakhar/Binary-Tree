public class BalancedBSTOrNot {
    Node root;

    public Node insert(Node node,int data) {
        if (node == null) {
            root = new Node(data);
            return root;
        }
        if (data < node.data) {
            if (node.left == null) {
                node.left = new Node(data);
            }
            else {
                insert(node.left,data);
            }
        }
        else if (data > node.data) {
            if (node.right == null) {
                node.right = new Node(data);
            }
            else {
                insert(node.right,data);
            }
        }
        return root;
    }

    public void printing(Node node) {
        if (node == null) {
            return;
        }
        printing(node.left);
        System.out.println(node.data + " ");
        printing(node.right);
    }

    public boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        int lheight = height(node.left);
        int rheight = height(node.right);
        if ((Math.abs(lheight - rheight) <= 1) && (balanced(node.left)) && (balanced(node.right))) {
            return true;
        }
        return false;
    }

    public int height(Node node) {
        int lheight;
        int rheight;
        if (node == null) {
            return 0;
        }
        lheight = height(node.left);
        rheight = height(node.right);


        if (lheight > rheight) {
            return lheight + 1;
        } else {
            return rheight + 1;
        }
    }

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BalancedBSTOrNot tree = new BalancedBSTOrNot();
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 1);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 4);
        tree.insert(tree.root, 7);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 12);

        if (tree.balanced(tree.root)) {
            System.out.println("Tree is balanced");
        }
        else {
            System.out.println("Tree is not balanced");
        }
    }
}