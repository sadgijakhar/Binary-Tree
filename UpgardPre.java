import java.util.*;
class Node{
	int data;
	Node left,right;
	
	Node(int value) {
		data = value;
		left = right = null;
	}
}

class Tree1{
	Node root;
	
	Tree1() {
		root = null;
	}
	
	// Method to construct a binary tree from the given array (Do not edit the code given below)
	public Node insertNode(int[] elementsArr, Node node, int i){
		if(i < elementsArr.length){
			node = new Node(elementsArr[i]);
			node.left = insertNode(elementsArr,node.left,2 * i + 1);
			node.right = insertNode(elementsArr,node.right,2 * i + 2);
		}
		return node;
	}
	// Method to print nodes that are multiple of root node
	public void printNodes(Node node){
        if(root.data == 0){
            System.out.println("Division by zero is undefined");
        }
        else{
            if(node ==null){
                return;
            }
            printNodes(node.left);
            if(node.data % root.data == 0 ){
                System.out.print(node.data +" ");
            }
            printNodes(node.right);
        }
    }
}

// WARNING: Do not edit the code given below, otherwise the test cases might fail
class Source{
	public static void main(String[] x){
		Tree1 tree = new Tree1();
	
		Scanner sc = new Scanner(System.in);
	    
	    int size;	
		size = sc.nextInt();
		
		if(size<= 0){
		    System.out.println("Size should be a positive integer");
		}
		
		else{
    		int[] elementsArr = new int[size];
    		for(int i = 0; i < size; i++){
    			elementsArr[i] = sc.nextInt();
    		}
    		tree.root = tree.insertNode(elementsArr,tree.root,0);
    		tree.printNodes(tree.root);
		}
        sc.close();
	}

    public Object root;

    public void add(int i) {
    }
}