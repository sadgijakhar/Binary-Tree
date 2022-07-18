public class BT {
    Node root ;
    class Node{
        int data;
        Node right , left ;
        Node(int data){
            this.data = data ;
            this.right = left = null ;
        }
    }
    public void add(int data){
        root = insert(root ,data);
    }
    public Node insert(Node root , int data){
        if(root == null){
            root = new Node(data);
        }
        else if(root.data > data){
            root.left = insert(root.left , data);
        }
        else{
            root.right = insert(root.right , data);
        }
        return root;
    }
    int t ;
    public void preOrder(Node root){
        t = root.data;
    }
    public void inOrder(Node root){
        try{
            if(root ==null){
                return;
            }
            inOrder(root.left);
            if(root.data % t == 0 ){
                System.out.print(root.data +" ");
            }
            inOrder(root.right);
        }
        catch(Exception c){
            System.out.println("Division by zero is undefined");
        }
        
    } 
    
    // public void postOrder(Node root){
    //     if(root == null){
    //         return;
    //     }
    //     postOrder(root.left);
    //     postOrder(root.right);
    //     System.out.print( root.data + " ");
    // }
    public static void main(String[] args) {
        BT tree = new BT();
        tree.add(5);
        tree.add(25);
        tree.add(30);
        tree.add(21);
        tree.add(220);
        tree.preOrder(tree.root);
        tree.inOrder(tree.root);
    }

}
