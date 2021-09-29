package exam_210526_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Node root;
    public void insert(int ele) {
        if(root == null) {
            root = new Node(ele);
        }
        else{
            Node head = root;
            Node now;
            while(true) {
                now = head;
                if(head.data > ele) {
                    head = head.left;
                    if(head == null) {
                        now.left = new Node(ele);
                        break;
                    }
                }
                else{
                    head = head.right;
                    if(head == null) {
                        now.right = new Node(ele);
                        break;
                    }
                }
            }
        }
    }

    public void preorder(Node root) {
        System.out.print(root.data + " ");
        if(root.left != null) preorder(root.left);
        if(root.right != null) preorder(root.right);
    }

    public void inorder(Node root) {
        if(root.left != null) inorder(root.left);
        System.out.print(root.data + " ");
        if(root.right != null) inorder(root.right);
    }

    public void postorder(Node root) {
        if(root.left != null) postorder(root.left);
        if(root.right != null) postorder(root.right);
        System.out.print(root.data + " ");
    }

    public void levelorder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            System.out.print(now.data + " ");

            if(now.left != null) {
                queue.add(now.left);
            }

            if(now.right != null) {
                queue.add(now.right);
            }
        }
    }
}




public class second_problem {

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        String [] line = br.readLine().split(" ");

        for(int i = 0; i< N; i++) {
            tree.insert(Integer.parseInt(line[i]));
        }
        tree.preorder(tree.root);
        System.out.println();
        tree.inorder(tree.root);
        System.out.println();
        tree.postorder(tree.root);
        System.out.println();
        tree.levelorder(tree.root);


    }
}
