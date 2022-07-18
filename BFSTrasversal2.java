import java.util.Queue;
import java.util.LinkedList;
class Node{
    int data;
    Node right ,left;
    Node(int data ){
        this.data = data;
        this.right =left =null;
    }
}
class Tree3{
    Node root ;
    Tree3(){
        root = null;
    }
    void levelOrderOrBFS(){
        Queue<Node>  q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.peek();
            System.out.print(temp.data + " ");
            q.remove();
            if(temp.left != null){
                q.add(temp.left);
            }
            if(temp.right!= null){
                q.add(temp.right);
            }
        }
    
    }
}
public class BFSTrasversal2 {
    public static void main(String[] args) {
        Tree3 tree = new Tree3();
        tree.root = new Node (1); 
        tree.root.left = new Node (2); 
        tree.root.right = new Node (3); 
        tree.root.left.left = new Node (4); 
        tree.root.left.right = new Node (5); 
        tree.root.right.left = new Node (6); 
        tree.root.right.right = new Node (7); 
        tree.levelOrderOrBFS();
    }
}
