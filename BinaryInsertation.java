public class BinaryInsertation {
    Node root;
    class Node{
        int data;
        Node right , left;
        Node(int data){
            this.data = data;
            this.right = left =null;
        }
    }
    public void insert(int data){
        root = insertRec(root,data);
    }
    public Node insertRec(Node root , int data) {
        if(root == null){
            root = new Node(data);
        }
        else if(root.data>data){
           root.left = insertRec(root.left, data);
        }
        else{
            root.right = insertRec(root.right, data);
        }
        return root;
    }  
    public void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public void inorder(Node root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
        
    }
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public Node search(Node root , int key){
        if(root == null || root.data== key){
            return root;
        }
        else{
            if(root.data > key){
                return search(root.left , key);
            }
            else{
                return search(root.right, key);
            }
        }
    }
    public void delete(int key){
        root = deleteRec(root , key);
    }
    public Node deleteRec(Node root , int key){
        if(root == null){
            return root;
        }
        else if(root.data >key){
            root.left = deleteRec(root.left , key);
        }
        else if(root.data <key){
            root.right = deleteRec(root.right , key);
        }
        else{
            if (root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                root.data = this.successor(root.right);
                root.right = deleteRec(root.right, root.data);
            }
            
        }
        return root;
    }
    public int successor(Node root){
        int min = root.data;
        Node temp = root;
        while(root.left != null){
            min = temp.data;
            temp = temp.left;
        }
        return min;
    }

    public static void main(String[] args) {
        BinaryInsertation tree = new BinaryInsertation();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        // System.out.println(tree.root);
        // System.out.println("PreOrder");
        
        // tree.inorder(tree.root);
        // System.out.println(" ");
        // System.out.println("PostOrder");
        // tree.postOrder(tree.root);
        
        if(tree.search(tree.root, 2)!=null){
            System.out.println();
            System.out.println("Element Found");
        }
        else{
            System.out.println();
            System.out.println("Not Found");
        }
        tree.delete(2);
        // tree.deleteRec(tree.root, 6);
        tree.preorder(tree.root);
        // System.out.println(" ");
        // System.out.println("InOrder");
            
    }
    
}
