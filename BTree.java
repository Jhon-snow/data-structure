package com.company;
import java.util.*;
public class BTree {

    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    // Constructor
    BTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }                                                     //to insert in the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    void bfs(){
        printTree(root);
    }



    void printTree(Node root) {
        Queue <Node> q=new LinkedList<Node>();
        Node temp=root;
        q.add(temp);
        while(!q.isEmpty()) {
            temp = q.peek();                               //for level order traversal
            System.out.print(q.peek().key + " ");
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);
            q.remove();
        }
    }


   void del(int key){
       Node temp= delkey(root,key);
       temp=null;
   }
Node delkey(Node root,int key){
        Node temp=null;
        if(root==null)
            System.out.println("node not found");
        else if(key<root.key)
           root.left= delkey(root.left,key);
        else if(key>root.key)
            root.right=delkey(root.right,key);
        else {
            if (root.left != null && root.right != null) {       // delete an element
                temp = minvalue(root.right);
                root.key = temp.key;
                root.right = delkey(root.right, root.key);

            }
                //temp = root;
        else {
                if (root.right == null)
                    return root.left;
                if (root.left == null)
                    return root.right;

            }
        }
        return root;
}





    void min(){
        Node temp= minvalue(root);
        if(temp==null)
            System.out.println("tree is empty");               //to find minimum element
        else
            System.out.println(temp.key);
    }



    Node minvalue(Node root){
        if(root==null)
           return null;
        else
            if(root.left==null)                                //to find minimum element
                return root;
                else
                   return minvalue( root.left);

    }

    public static void main(String[] args) {
        BTree tree = new BTree();

		/* Let us create following BST
			50
		/	 \
		30	 70
		/ \ / \
	20 40 60 80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.bfs();
        tree.min();
        tree.del(100);
        tree.bfs();
    }

}
