package practice_210602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Heap {
    ArrayList<Integer> arr = new ArrayList<>();

    public Heap() {
        arr.add(0);
    }

    void insert(int n) {
        arr.add(n);
        int idx = arr.size() - 1;
        while(idx > 0) {
            int parent = idx / 2 ;

            if(parent < 1 || arr.get(parent) < arr.get(idx)){
                break;
            }
            swap(idx, parent);

            idx = parent;
        }
    }
    int delete() {
        int idx = arr.size() - 1;

        if(idx == 0) {
            return 0;
        }
        int tmp = arr.get(1);
        swap(1, idx);
        arr.remove(arr.size() - 1);
        minHeapify(1);

        return tmp;
    }
    void minHeapify(int index) {
        int left = index * 2;
        int right = index * 2 + 1;
        int i = index; //부모노드

        if(left < arr.size() && arr.get(left) < arr.get(i)){
            i = left;
        }
        if(right < arr.size() && arr.get(right) < arr.get(i)) {
            i = right;
        }
        if(index != i) {
            swap(index, i);
            minHeapify(i);
        }
    }

    void swap(int target, int idx) {
        int temp = arr.get(idx);
        arr.set(idx, arr.get(target));
        arr.set(target, temp);
    }
}
public class problem_min {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        Heap h = new Heap();

        for(int i = 0; i < testcase; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                System.out.println(h.delete());
                continue;
            }

            h.insert(num);
        }
    }
}
