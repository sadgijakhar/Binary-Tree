
import java.util.*;

class Node {
	int data;
	Node left, right;
	
	Node(int value) {
		data = value;
		left = right = null;
	}
}

class Tree6 {
	Node root;
	
	Tree6() {
		root = null;
	}
	
	// Method to construct a binary tree from the given array
	public Node insertNode(int[] elementsArr, Node node, int i) {
		if(i < elementsArr.length){
			node = new Node(elementsArr[i]);
			node.left = insertNode(elementsArr,node.left,2 * i + 1);
			node.right = insertNode(elementsArr,node.right,2 * i + 2);
		}
		return node;
	}
	
	// Method to print the tree in pre-order traversal
    void preOrderDFS(Node node) {
        if (node == null)
            return;

        // visit the parent node (parent of left & right children)
        System.out.print(node.data + " ");
        // recursively go to left subtree
        preOrderDFS(node.left);
        // recursively go to right subtree
        preOrderDFS(node.right);
    }
	
	// Method to convert a given binary tree into its mirror image
	public Node mirror(Node node) {
        if (node == null)
        return node;

    /* do the subtrees */
        Node left = mirror(node.left);
        Node right = mirror(node.right);

    /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
	}
}

// WARNING: Do not edit the code given below; otherwise the test cases might fail
public class Mirror {
	public static void main(String[] x) {
		Tree6 tree = new Tree6();
		
		int size;
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		
		if(size <= 0){
		    System.out.println("Size should be a positive integer");
		}
		
		else{
    		int[] elementsArr = new int[size];
    		for(int i = 0; i < size; i++) {
    			elementsArr[i] = sc.nextInt();
    		}
    		
    		tree.root = tree.insertNode(elementsArr, tree.root, 0);
    		
    		tree.mirror(tree.root);
    		
    		tree.preOrderDFS(tree.root);
		}
        sc.close();
	}
    
}
