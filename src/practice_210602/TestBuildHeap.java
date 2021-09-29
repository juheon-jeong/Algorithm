package practice_210602;

import java.util.Arrays;

public class TestBuildHeap {        //maxheap

    public TestBuildHeap() {
        int [] a = {22, 33, 44, 55, 66, 77, 88, 99};
        System.out.println(Arrays.toString(a));
        buildHeap(a, 0);
        System.out.println(Arrays.toString(a));
    }

    void buildHeap(int[] a, int i) {
        int n = a.length;
        if( i >= n/2) return;
        buildHeap(a, 2 * i + 1);
        buildHeap(a, 2 * i + 2);
        heapify(a, i);
    }

    void heapify(int [] a, int i) {
        int n = a.length;
        int ai = a[i];
        System.out.println("Heapify at node " + i + " a[i] " + ai);
        System.out.println("Before Heapify" + Arrays.toString(a));
        while( i < n/2) {
            int j = 2*i + 1;  //왼쪽 자식노드
            if( j + 1 < n && a[j+1] > a[j]) ++j;
            if(a[j] <= ai) break;
            a[i] = a[j];
            i = j;
        }
        a[i] = ai;
        System.out.println("After Heapify " + Arrays.toString(a));
    }

    public static void main(String[] args) {
        new TestBuildHeap();
    }
}
