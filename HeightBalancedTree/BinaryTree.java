package HeightBalancedTree;

import java.util.ArrayList;
import java.util.List;

class BST{
    class Node{
        int value;
        int height;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
            this.height = 0;
            this.left = null;
            this.right = null;
        }
    }
    Node root = null;

    public int height(Node root){
        if(root==null){
            return 0;
        }else{
            return root.height;
        }
    }

    public Node leftRotate(Node root){
        Node x = root.right;
        Node t2 = x.left;
        x.left = root;
        root.right = t2;
        root.height = Math.max(height(root.left),height(root.right))+1;
        x.height = Math.max(height(x.left),height(x.right))+1;
        return x;
    }
    public Node rightRotate(Node root){
        Node x = root.left;
        Node t2 = x.right;
        x.right = root;
        root.left = t2;
        root.height = Math.max(height(root.left),height(root.right))+1;
        x.height = Math.max(height(x.left),height(x.right))+1;
        return x;
    }

    public Node insertNode(Node root,int value){
        if(root==null){
            root = new Node(value);
        }else if(root.value>value){
            root.left = insertNode(root.left, value); 
        }else if(root.value<value){
            root.right = insertNode(root.right, value);
        }
        root.height = 1+Math.max(height(root.left),height(root.right));
        int balance = getBalance(root);
        if(balance>1 && value<root.left.value){
            return rightRotate(root);
        }
        if(balance<-1 && value>root.right.value){
            return leftRotate(root);
        }
        if(balance>1 && value>root.left.value){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance<-1 && value<root.right.value){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public void add(int value){
        this.root = insertNode(this.root, value);
    }

    public void inOrder(Node root,List<Integer> lst){
        if(root == null){
            return;
        }
        if(root.left != null){
            inOrder(root.left,lst);
        }
        lst.add(root.value);
        if(root.right != null){
            inOrder(root.right, lst);
        }
    }
    public List<Integer> traverse(){
        List<Integer> lst = new ArrayList<>();
        inOrder(this.root, lst);
        return lst;
    }
    public int getBalance(Node root){
        if(root==null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }
    public int getBalance(){
        return getBalance(this.root);
    }

}
public class BinaryTree {
    public static void main(String[] args){
        BST tree = new BST();
        tree.add(3);
        tree.add(2);
        tree.add(1);
        tree.add(4);
        System.out.println(tree.traverse().toString());
        System.out.println(tree.getBalance());
    }
}
