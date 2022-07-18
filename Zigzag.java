
import java.util.*;
class Node {
    int data;
	Node left, right;
	
	Node(int value) {
		data = value;
		left = right = null;
	}
}

class Tree7 {
	Node root;
	
	Tree7() {
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
    int height(Node root){
        if(root == null){
            return 0;
        }
        int HLeft =  height(root.left);
        int HRight  =  height(root.right);
        if(HLeft < HRight){
            return HRight + 1;
        }
        else{
            return HLeft + 1;
        }
    }
    
    void spiralOrder(){
        int h = height(root);
        boolean flag = false;
        for(int i = 1 ; i<= h ;i++){
            
            printNodesAtLevel(root, i ,flag);
            flag = !flag;
        }
    }
    void printNodesAtLevel(Node node, int level , boolean flag){
        
        
        if(node == null){
            return;
        }
        else if (level == 1){
            System.out.print(node.data + " ");
        }
        else if (level >1){
            if(flag != false){
                printNodesAtLevel(node.left, level -1,flag);
                printNodesAtLevel(node.right, level -1,flag);
            }
            else{
                printNodesAtLevel(node.right, level -1,flag);
                printNodesAtLevel(node.left, level -1,flag);
            }
        }
    }
	
	// Method to traverse the elements of a tree using BFS (level-order traversal) in the spiral order
    
}

// WARNING: Do not edit the code given below; otherwise the test cases might fail
public class Zigzag{
	public static void main(String[] x) {
		Tree7 tree = new Tree7();
		
		int size;
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		if (size < 0){
		    System.out.println("Size should be a positive integer");
		}
		
		else{
    		int[] elementsArr = new int[size];
    		for(int i = 0; i < size; i++) {
    			elementsArr[i] = sc.nextInt();
    		}
    		
    		tree.root = tree.insertNode(elementsArr, tree.root, 0);
    		
    		tree.spiralOrder();
		}
        sc.close();
	}
}
