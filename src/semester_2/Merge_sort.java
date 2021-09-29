package semester_2;
import java.util.*;
import java.io.*;

public class Merge_sort {
    static int count = 0;
    static int max_show = 10;

    public static void main(String[] args) {
        String _Sort = "Merge_sort";
        String filePath = "./data02.txt";
        String out_filePath = "hw02_00_201802155_" + _Sort + ".txt";
        System.out.println(_Sort);

        int[] array = read(filePath);
        array = mergeSort(array, 0, array.length - 1);
        write(array, out_filePath);
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
        for(int i = 0; i < array.length - 1; i++){
            str += Integer.toString(array[i]) + ",";
        }
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

    public static int[] mergeSort(int [] arr, int start, int end){
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
        return arr;
    }
    public static void merge (int [] arr, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int[] tmp = new int[arr.length];
        int index = left;

        while(left <= mid && right <= end) {
            if(arr[left] <= arr[right]) {           //left, right 값 비교하여 더 작은 값 임시 배열에 저장
                tmp[index] = arr[left];
                left++;
                index ++;
            }
            else {
                tmp[index] = arr[right];
                right++;
                index++;
            }
        }

        if(left > mid) {       //left값이 mid보다 큰 경우 right에 더 큰값들이 남아 있으므로 남은 값 저장
            for(int i = right; i <= end; i++,index++){
                tmp[index] = arr[i];
            }
        }
        else{                   //left값에 큰 값이 남아 있으므로 남은 값 저장
            for(int i = left; i <= mid; i++, index++) {
                tmp[index] = arr[i];
            }
        }
        for(int i = start; i <= end; ++i) {
            arr[i] = tmp[i];
        }
    }
}
