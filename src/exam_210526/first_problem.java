package exam_210526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    String data;
    Node left, right;
    public Node(String data) {
        this.data = data;
    }
}

class Tree {
    Node root;

    public void Add(String data, String left_data, String right_data) {
        if(root == null) {
            if(!data.equals(".")) {
                root = new Node(data);
            }
            if(!left_data.equals(".")) {
                root.left = new Node(left_data);
            }
            if (!right_data.equals(".")) {
                root.right = new Node(right_data);
            }
        }
        else{
            Search(root, data, left_data, right_data);
        }
    }

    public void Search(Node root, String data, String left_data, String right_data) {
        if(root == null) return;

        else if(root.data.equals(data)) {
            if(!left_data.equals(".")) {
                root.left = new Node(left_data);
            }
            if (!right_data.equals(".")) {
                root.right = new Node(right_data);
            }
        }

        else{
            Search(root.left, data, left_data, right_data);
            Search(root.right, data, left_data, right_data);
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


public class first_problem {

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for(int i = 0; i < testcase; i++) {
            String [] text = br.readLine().split(" ");
            tree.Add(text[0], text[1], text[2]);
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
