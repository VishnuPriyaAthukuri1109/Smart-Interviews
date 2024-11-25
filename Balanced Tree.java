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
    public int height(Node root){
        if(root==null) return 0;
        int ls=height(root.left);
        if(ls==-1) return -1;
        int rs=height(root.right);
        if(rs==-1) return -1;
        if(Math.abs(rs-ls)>1) return -1;
        return Math.max(ls,rs)+1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        Main tree=new Main();
        while(t-->0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Node root=null;
            for(int i=0;i<n;i++){
                root=tree.insert(root,arr[i]);
            }
            if(tree.height(root)!=-1)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
    }
}