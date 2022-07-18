class Node{
    int data;
    Node right, left ;
    Node(int data){
        this.data = data;
        this.right = left = null;
    }
}
class Tree2{
    Node root;
    Tree2(){
       root = null;
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
    void insertLevelOrder(){
        int h = height(root);
        for(int i = 1 ; i<= h ;i++){
            printNodesAtLevel(root, i, 1);
        }
    }
    void printNodesAtLevel(Node root, int level, int currentLevel) {
        if(root == null){
            return ;
        }
        else if (level == currentLevel){
            System.out.print(root.data + " ");
        }
        else {
            
            printNodesAtLevel(root.left, level, currentLevel+1);
            printNodesAtLevel(root.right, level, currentLevel+1);
             
        }
    }
    
}
public class BFSTrasversal {
    public static void main(String[] args) {
        Tree2 tree = new Tree2();
        tree.root = new Node (1); 
        tree.root.left = new Node (2); 
        tree.root.right = new Node (3); 
        tree.root.left.left = new Node (4); 
        tree.root.left.right = new Node (5); 
        tree.root.right.left = new Node (6); 
        tree.root.right.right = new Node (7); 
        tree.insertLevelOrder();
    }
}
