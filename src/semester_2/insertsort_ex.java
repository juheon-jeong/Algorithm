package semester_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class insertsort_ex {
    static int count = 0;
    public static void main(String [] args) throws IOException{
        String _Sort = "Insertion_sort";
        String filePath = "./data01.txt";
        String out_filePath = "hw01_00_201802155_" + _Sort + ".txt";
        System.out.println(_Sort);

        int[] array = read(filePath);
        array = Sort(array);
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
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] Sort(int [] arr) {
        for(int i = 1; i < arr.length; i++) {
            int compare = arr[i];                    //????????? ??????
            int j = i - 1;                          //?????? ???????????? ?????? ?????? ??? ?????? ????????? ??????

            while(j >= 0 && compare < arr[j]){       //????????? ????????? ?????? ???????????? ????????? ????????? ??????
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = compare;                   //j?????? ????????? compare?????? ?????? ??????????????? j+1?????? ????????? compare??? ????????????.
        }
        return arr;
    }
}
