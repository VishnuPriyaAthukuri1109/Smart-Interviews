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
    
    public int diameter(Node root,int[] dia){
        if(root==null)return 0;
        int leftheight=diameter(root.left,dia);
        int rightheight=diameter(root.right,dia);
        dia[0]=Math.max(dia[0],leftheight+rightheight);
        return Math.max(leftheight,rightheight)+1;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        Main tree=new Main();
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String[] arr=br.readLine().split(" ");
            Node root=null;
            for(String i: arr){
                root=tree.insert(root,Integer.parseInt(i));
            }
            int[] dia=new int[1];
            tree.diameter(root,dia);
            System.out.println(dia[0]+1);
        
            
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
    }
}