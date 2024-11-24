import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    public Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        if(data<root.data)
        root.left=insert(root.left,data);
        else if(data>root.data)
        root.right=insert(root.right,data);
        return root;
    }
    public Node delete(Node root,int key){
        if(root==null)
        return null;
        if(key<root.data)
        root.left=delete(root.left,key);
        else if(key>root.data)
        root.right=delete(root.right,key);
        else{
            if(root.left==null && root.right==null)
            return null;
            else if(root.left!=null && root.right==null)
            return root.left;
            else if(root.right!=null && root.left==null)
            return root.right;
            root.data=findMin(root.right);
            root.right=delete(root.right,root.data);
        }
         return root;
    }
    public int findMin(Node root){
        int mini=root.data;
        while(root.left!=null){
            root=root.left;
            mini=root.data;
        }
        return mini;
    }
    public boolean search(Node root,int key){
        if(root==null) return false;
        if(key==root.data) return true;
        if(key<root.data) return search(root.left,key);
        return search(root.right,key);
    }
    public void preorder(Node root){
        if(root==null)return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int test=1;test<=t;test++){
            System.out.println("Case #"+ test +":");
            int q=sc.nextInt();
            Main tree=new Main();
            Node root=null;
            for(int i=0;i<q;i++){
                int query=sc.nextInt();
                if(query==1)
                {
                    int x=sc.nextInt();
                    root=tree.insert(root,x);
                }else if(query==2){
                    int x=sc.nextInt();
                    root=tree.delete(root,x);
                }else if(query==3){
                    int x=sc.nextInt();
                    if(tree.search(root,x)){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                }else if(query==4){
                    tree.preorder(root);
                    System.out.println();
                }
            }
        }
            
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
    }