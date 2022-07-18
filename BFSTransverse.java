class Node{
    int data;
    Node left ,right ;
    Node(int data){
        this.data = data;
        this.right = left =null;
    }
}
class Tree4{
    Node root;
    Tree4(){
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
            printNodesAtLevel(root, i);
        }
    }
    void printNodesAtLevel(Node node, int level){
        if(node == null){
            return;
        }
        else if (level == 1){
            System.out.println(node.data);
        }
        else{
            printNodesAtLevel(node.left, level -1);
            printNodesAtLevel(node.right, level -1);
        }
    }

}
public class BFSTransverse{
    public static void main(String[] args) {
        Tree4 tree = new Tree4();
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
