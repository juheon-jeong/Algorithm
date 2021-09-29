package practice_210602;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class heaps {
    ArrayList<Integer> arr = new ArrayList<>();

    public heaps() {
        arr.add(0);
    }

    void insert(int num) {
        arr.add(num);
        int index = arr.size() -1;
        while(index > 0) {
            int parent = index / 2;

            if(parent < 1 || arr.get(parent) > arr.get(index)) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }
    int delete() {
        int index = arr.size() - 1;

        if(index == 0) {  //비어있다는 것을 의미
            return 0;
        }
        int tmp = arr.get(1);
        swap(1, index);
        arr.remove(arr.size() - 1 );
        maxHeapify(1);

        return tmp;
    }

    void maxHeapify(int index) {
        int left = index * 2;
        int right = index * 2 + 1;
        int i = index;

        if(left < arr.size() && arr.get(left) > arr.get(i)) {
            i = left;
        }
        if(right < arr.size() && arr.get(right) > arr.get(i)) {
            i = right;
        }
        if(index != i) {
            swap(index, i);
            maxHeapify(i);
        }
    }

    void swap(int target, int index) {
        int temp = arr.get(index);
        arr.set(index, arr.get(target));
        arr.set(target, temp);
    }

}
public class problem_max {

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        heaps h  = new heaps();

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
