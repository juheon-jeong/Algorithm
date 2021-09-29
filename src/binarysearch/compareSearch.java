package binarysearch;

import java.util.Random;

public class compareSearch {
    public static void main(String[] args) {
        for(int i = 1000; i <= 100000; i += 1000){
            System.out.printf("%d %d %d", i, timeSeqSearch(i), timeBinSearch(i));
        }
    }

    static int[] generateInput(int n){
        int[] a =new int[n];
        for(int i = 0; i < n; i++){
            a[i] = i;
        }
        return  a;
    }

    static int seqSearch(int[] a, int target){
        for(int i = 0; i < a.length; i++){
            if(a[i] == target)
                return i;
        }
        return -1;
    }

    static int binSearch(int[] a, int left, int right, int target){
        if(left > right) return -1;
        int middle = (left+right) /2;
        if(a[middle] > target){
            binSearch(a, left, middle-1, target);
        }
        else if(a[middle] < target){
            binSearch(a, middle + 1, right, target);
        }
        return middle;
    }

    static long timeSeqSearch(int n){
        Random target = new Random();
        int[] inputArray = generateInput(n);

        long start = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            seqSearch(inputArray, target.nextInt(n) + 1);
        }
        long stop = System.nanoTime() - start;
        return stop / 1000;
    }

    static long timeBinSearch(int n) {
        Random target = new Random();
        int[] inputArray = generateInput(n);


        long start = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            binSearch(inputArray,0, inputArray.length-1, target.nextInt(n) + 1);
        }
        long stop = System.nanoTime() - start;
        return stop / 1000;
    }
}
