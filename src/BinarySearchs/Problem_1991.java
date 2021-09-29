package BinarySearchs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    char data;
    Node left, right;
    public Node(char data) {
        this.data = data;

    }

}
class Tree {
    Node root;

    public void Add(char data, char left_data, char right_data) {
        if(root == null) {
            if(data != '.') root = new Node(data);
            if(left_data != '.') root.left = new Node(left_data);
            if(right_data != '.') root.right = new Node(right_data);
        }
        else Search(root, data, left_data, right_data);
    }

    public void Search(Node root, char data, char left_data, char right_data){
        if(root == null) return;

        else if(root.data == data){
            if(left_data != '.') root.left = new Node(left_data);
            if(right_data != '.') root.right = new Node(right_data);
        }

        else{
            Search(root.left, data, left_data, right_data);
            Search(root.right, data, left_data, right_data);
        }
    }

    public void preorder(Node root) {
        System.out.print(root.data);
        if(root.left != null) preorder(root.left);
        if(root.right != null) preorder(root.right);
    }

    public void inorder(Node root) {
        if(root.left != null) inorder(root.left);
        System.out.print(root.data);
        if(root.right != null) inorder(root.right);
    }

    public void postorder(Node root) {
        if(root.left != null) postorder(root.left);
        if(root.right != null) postorder(root.right);
        System.out.print(root.data);
    }
}

public class Problem_1991 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for(int i = 0; i < testcase; i++) {
            String [] text = br.readLine().split(" ");
            tree.Add(text[0].charAt(0), text[1].charAt(0), text[2].charAt(0));
        }

        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);



    }


}


