
import java.util.*;


class Node { 
	int data; 
	Node left, right; 

	public Node(int value) { 
		data = value; 
		left = right = null; 
	} 
} 

class BinaryTree { 

	Node root; 

    BinaryTree(){
        root = null;
    }	
    
    // Method to construct a binary tree from the given array
	public Node insertNode(int[] elementsArr, Node node, int i){
		if(i < elementsArr.length){
			node = new Node(elementsArr[i]);
			
			node.left = insertNode(elementsArr,node.left,2 * i + 1);
			node.right = insertNode(elementsArr,node.right,2 * i + 2);
		}
		return node;
	}
	
	// Method to find the largest value in the tree
	public int findMax(Node node) 
	{ 
	    if(node.data == 0){
            return -1;
        }
		Queue<Node>  q = new LinkedList<>();
		Queue<Node>  q1= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.peek();
            q1.add(q.remove());
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right!= null){
                q.add(temp.right);
            }
        }
        
        q1.add(root);
        Node max= q1.remove();
        while(!q1.isEmpty()){
            Node temp2 = q1.remove();
            if(temp2.data > max.data){
				max = temp2;
                
            }
			
        }  
		return max.data; 
        
	} 
}
// WARNING: Do not edit the code given below; otherwise the test cases might fail
public class MaxValueNode{
	public static void main(String[] x){
		BinaryTree tree = new BinaryTree();
		
		int size;
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		
		if(size == 0){
		    System.out.println("-1");
		}
		
		else if (size < 0){
		    System.out.println("Size should be a positive integer");
		}
		
		else{
        		int[] elementsArr = new int[size];
        		for(int i = 0; i < size; i++){
        			elementsArr[i] = sc.nextInt();
        		}
        		
        		tree.root = tree.insertNode(elementsArr,tree.root,0);
        		System.out.println(tree.findMax(tree.root));
    	}
		sc.close();
	}
	
}