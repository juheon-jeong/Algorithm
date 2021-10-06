package semester_2;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class HeapSort {
    static int count = 0;
    static int size = 0;
    static int max_show = 10;

    public static void main(String[] args) {
        String _Sort = "Heap_sort";
        String filePath = "./data03.txt";
        String out_filePath = "hw03_00_201802155_" + _Sort + ".txt";
        System.out.println(_Sort);
        int[] array = read(filePath);

        write(heapSort(array), out_filePath);
        System.out.println(count);
    }

    public static int[] read(String _path){
        String contents = "";
        try(FileInputStream fstream = new FileInputStream(_path)) {
            byte[] rb = new byte[fstream.available()];
            while (fstream.read(rb) != -1) {
            }
            fstream.close();
            contents = new String(rb);
        }catch (Exception e){
            e.getStackTrace();
        }
        StringTokenizer st = new StringTokenizer(contents, ",");
        int[] array = new int[st.countTokens()];
        for(int i = 0; st.hasMoreElements(); i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        print_array(array);
        return array;
    }

    public static void print_array(int[] array) {
        for(int i = 0; i < max_show; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void write(int[] array, String out_filePath){
        print_array(array);
        String str = "";
        for(int i = 0; i < array.length - 1; i++)
            str += Integer.toString(array[i]) + ",";
        str += Integer.toString(array[array.length - 1]);
        try(FileWriter fw = new FileWriter(out_filePath)){
            fw.write(str);
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static int[] heapSort(int[] array) {
            size = array.length;
            build_max_heap(array);
            for(int i = array.length; i > 1; i--) {
                swap(array, 0, i - 1);
                size = size - 1;
                max_heapify(array, 0);
            }
            return array;
    }

    public static void build_max_heap(int[] array){
        for (int i = array.length/2; i > 0; i--){
            max_heapify(array, i - 1);
        }
    }

    public static void max_heapify(int[] array, int paidx) {
        int leftidx = 2 * paidx + 1;
        int rightidx = 2 * paidx + 2;
        int maxidx = paidx;

        if(leftidx < size && array[leftidx] > array[maxidx]){
            maxidx = leftidx;
        }

        if(rightidx < size && array[rightidx] > array[maxidx]){
            maxidx = rightidx;
        }

        if(paidx != maxidx) {
            swap(array, maxidx, paidx);
            max_heapify(array, maxidx);
        }
        count++;
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
