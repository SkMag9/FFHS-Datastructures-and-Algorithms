package ch.ffhs.dua.sort;

import java.util.Random;

public class TestQuickSortPlus {
    static int[] unsortedArray = null;
    static int[] sortedArray = null;
    static int[] sortedArray2 = null;

    public static void getArray(int size){
        // Creates a randomized array of arraySize size
        unsortedArray = new int[size];

        Random random = new Random();

        for (int j = 0; j < unsortedArray.length; j++) {
            unsortedArray[j] = random.nextInt(100);
        }

        // copy of the unsorted array used for sorts
        sortedArray = new int[size];
        sortedArray2 = new int[size];
    }


    public static void testQuickSort(int size, boolean verbose){

        //normal quicksort
        System.arraycopy(unsortedArray, 0, sortedArray, 0, unsortedArray.length);
        double quickStartTime = System.nanoTime();
        QuickSort.sort(sortedArray);
        double quickDuration = (System.nanoTime() - quickStartTime);

        // improved quicksort
        System.arraycopy(unsortedArray, 0, sortedArray2, 0, unsortedArray.length);
        double quickPlusStartTime = System.nanoTime();
        QuickSort.sortPlus(sortedArray2);
        double quickPlusDuration = (System.nanoTime() - quickPlusStartTime);



        double ratio = quickDuration / quickPlusDuration;

        if(verbose){
            System.out.println("size: " + size);
            System.out.println("QuickSortPlus: " + quickPlusDuration);
            System.out.println("QuickSort: " + quickDuration);
            System.out.println("QuickSortPlus ist " + ratio + " Mal so schnell wie QuickSort");
        }
    }

    public static void main(String[] args){
        getArray(10);
        testQuickSort(10, true);
        System.out.println();


        getArray(100);
        testQuickSort(100, true);
        System.out.println();


        getArray(200);
        testQuickSort(200, true);
        System.out.println();


        getArray(600);
        testQuickSort(500, true);
        System.out.println();


        System.out.println("it is really unclear which one is faster but the problem is probably with java run times." +
                "or with the benchmarking methodology used ");
    }

}
