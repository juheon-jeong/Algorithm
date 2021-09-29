package semester_2;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;

public class Quick_sort {
    static int count = 0;
    static int max_show = 10;

    public static void main(String [] args) {
        String _Sort = "Quick_Sort";
        String filePath = "./data02.txt";
        String out_filePath = "hw02_00_201802155_" + _Sort + ".txt";
        System.out.println(_Sort);
        int [] array = read(filePath);

        write(quickSort(array.clone(), 0, array.length - 1), out_filePath);

        System.out.println(count);

        _Sort = _Sort + "WithRandomizedPartiton";
        System.out.println(_Sort);
        count = 0;
        int [] array_th = read(filePath);


        write(quickSort_withRandom(array_th, 0, array_th.length - 1), out_filePath);

        System.out.println(count);
    }

    public static int[] read(String _path){
        String contents = "";
        try(FileInputStream fstream = new FileInputStream(_path);) {
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
    public static void write(int[] array, String out_filePath){
        print_array(array);
        String str = "";
        for(int i = 0; i < array.length - 1; i++)
            str += Integer.toString(array[i]) + ",";
        str += Integer.toString(array[array.length - 1]);
        try(FileWriter fw = new FileWriter(out_filePath);){
            fw.write(str);
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void print_array(int[] array) {
        for(int i = 0; i < max_show; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] quickSort(int [] arr, int start, int end) {
        if(start <= end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
        return arr;
    }

    public static int partition(int [] arr, int start, int end) {
        int x = arr[end];
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(arr[j] <= x){
                i = i + 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = tmp;
        return i + 1;
    }

    public static int randomized_partition(int[] arr, int start, int end) {
        Random random = new Random();
        int i = random.nextInt(start+end) + start;
        int temp = arr[end];
        arr[end] = arr[i];
        arr[i] = temp;
        return partition(arr, start, end);
    }

    public static int[] quickSort_withRandom(int [] arr, int start, int end) {
        if(start <= end) {
            int pivot = randomized_partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
        return arr;
    }
}
