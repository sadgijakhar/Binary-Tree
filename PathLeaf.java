import java.util.*;
public class PathLeaf{

    public static class Node  
    { 
        int data; 
        Node left, right; 
    
        Node(int item)  
        { 
            data = item; 
            left = right = null; 
        } 
    } 
   
    public static class BinaryTree  
    { 
        Node root; 
        BinaryTree() {
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
        
        void printPaths(Node node)  
        { 
            int path[] = new int[1000]; 
            print(node, path, 0); 
        } 
    
        void print(Node node, int path[], int pathLen)  
        { 
            if (node == null)
            return;
  
            path[pathLen] = node.data;
            pathLen++;
  
            if (node.left == null && node.right == null)
                printArray(path, pathLen);
            else
            {
                print(node.left, path, pathLen);
                print(node.right, path, pathLen);
            }
                    
            // complete this function
        } 
    
        void printArray(int ints[], int len)  
        { 
            int i; 
            for (i = 0; i < len; i++)  
            { 
                System.out.print(ints[i] + " "); 
            } 
            System.out.println(""); 
        } 
   
    } 
    public static void main(String args[])  
    { 
        BinaryTree tree = new BinaryTree(); 
        
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
    		tree.printPaths(tree.root);
		}
        sc.close();
       
         
    } 
}
