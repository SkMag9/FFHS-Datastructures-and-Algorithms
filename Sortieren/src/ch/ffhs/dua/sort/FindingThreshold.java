package ch.ffhs.dua.sort;

import java.util.Random;

public class FindingThreshold {

    public static String test(int arraySize, boolean verbose){
        int pointsInsert = 0;
        int pointsQuick = 0;

        int i = 0;
        while (i < 100){
            // Creates a randomized array of arraySize size
            int[] unsortedArray = new int[arraySize];

            Random random = new Random();

            for (int j = 0; j < unsortedArray.length; j++) {
                unsortedArray[j] = random.nextInt(100);
            }

            int[] sortedArray = new int[arraySize];
            // copy of the unsorted array used for sorts
            System.arraycopy(unsortedArray, 0, sortedArray, 0, unsortedArray.length);

            // Insert Sort with time measurement
            long insertStartTime = System.nanoTime();
            InsertSort.sort(sortedArray);
            long insertEndTime = System.nanoTime();
            long insertDuration = (insertEndTime - insertStartTime);

            // reset sortedArray to unsortedArray
            System.arraycopy(unsortedArray, 0, sortedArray, 0, unsortedArray.length);

            // QuickSort with time measurement
            long quickStartTime = System.nanoTime();
            QuickSort.sort(sortedArray);
            long quickEndTime = System.nanoTime();
            long quickDuration = (quickEndTime - quickStartTime);

            // compare and give point to faster one
            if(insertDuration < quickDuration){
                pointsInsert++;
            } else if(quickDuration < insertDuration){
                pointsQuick++;
            }

            i++;
        }

        if (verbose){
            System.out.println("With length "+arraySize+":");
        }

        if(pointsInsert > pointsQuick){
            return "Insertsort is faster with "+pointsInsert+" to Quicksorts "+pointsQuick;
        }
        if(pointsInsert < pointsQuick){
            return "Quicksort is faster with "+pointsQuick+" to Insertsorts "+pointsInsert;
        }
        // returns this if equal
        return "It was a tie with "+pointsInsert+" points for both sorts";
    }

    public static void main(String[] args) {
        // Warmup Phase
        for (int i = 0; i < 1000; i++){
            test(1000, false);
        }

        System.out.println(test(10, true));
        System.out.println(test(100, true));
        System.out.println(test(1000, true));

        System.out.println("The threshold is between 100 and 1000.");

        System.out.println(test(100, true));
        System.out.println(test(200, true));
        System.out.println(test(300, true));
        System.out.println(test(400, true));
        System.out.println(test(500, true));

        System.out.println("The threshold is between 400 and 500 since 450 sometimes give different results");
        System.out.println("So the threshold set in Quicksort will be 300");
    }
}
