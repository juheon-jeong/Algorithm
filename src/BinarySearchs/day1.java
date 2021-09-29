package BinarySearchs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Solution {
    public static ArrayList<Nodes> nodeList = new ArrayList<>();
    public static int index = 0;
    public int[][] solution(int[][] nodeinfo) {
        for(int i = 0; i < nodeinfo.length; i++){
            nodeList.add(new Nodes(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        Collections.sort(nodeList);

        Nodes root = nodeList.get(0);

        for(int i = 1; i < nodeList.size(); i++) {
            Nodes child = nodeList.get(i);
            connectNode(root, child);
        }

        int[][] answer = new int[2][nodeList.size()];

        preorder(answer, root);
        index = 0;

        postorder(answer, root);

        return answer;
    }

    public static void connectNode(Nodes parent, Nodes child) {
        if(child.x < parent.x) {
            if(parent.left == null) {
                parent.left = child;
            } else {
                connectNode(parent.left, child);
            }
        } else {
            if(parent.right == null) {
                parent.right = child;
            } else {
                connectNode(parent.right, child);
            }
        }
    }

    public static void preorder(int [][] arr, Nodes node) {
        if(node != null) {
            arr[0][index++] = node.data;
            if(node.left != null) preorder(arr, node.left);
            if(node.right != null) preorder(arr, node.right);
        }
    }

    public static void postorder(int [][] arr, Nodes node) {
        if(node != null) {
            if(node.left != null) postorder(arr, node.left);
            if(node.right != null) postorder(arr, node.right);
            arr[1][index++] = node.data;
        }
    }
}

class Nodes implements Comparable<Nodes> {
    int data;
    int x;
    int y;
    Nodes left;
    Nodes right;

    Nodes(int data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }

    public int compareTo(Nodes n) {
        return n.y - this.y;
    }
}
public class day1 {
    public static void main (String [] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));


    }
}
