//package practice;
//
//class Node {
//    public Node next = null;
//    public Node prev = null;
//    public Object data = null;
//    Node(Object data) {
//        this.data = data;
//    }
//    Node(Object data, Node next) {
//        this.data = data;
//        this.next = next;
//    }
//    Node(Object data, Node prev, Node next) {
//        this.data = data;
//        this.prev = prev;
//        this.next = next;
//    }
//}
//
//public class CircularDoubleLinkedList implements DoubleLinked {
//    private Node head;
//    private int size;
//
//    public CircularDoubleLinkedList() {
//        this.head = new Node(null, head, head);
//        this.size = 0;
//    }
//
//    public boolean insertFirst(Object data) {
//        if(isEmpty()) {
//            head.next = new Node(data,head,head);
//            head.prev = head.next;
//        }else {
//            Node tmp = head.next;
//            head.next = new Node(data, head, tmp);
//            tmp.prev = head.next;
//        }
//        size++;
//        return true;
//    }
//}
