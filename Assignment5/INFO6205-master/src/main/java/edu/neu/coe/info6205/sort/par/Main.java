package edu.neu.coe.info6205.sort.par;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            ParSort.cutoff = Integer.parseInt(args[0]);
        }
        Random random = new Random(0L);
        int[] array = new int[800000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000);
        }
        
        long startTime = System.currentTimeMillis();
        ParSort.sort(array, 0, array.length);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Sorting time: " + (float)elapsedTime + " milliseconds");
        System.out.println("Number of cores: " + Runtime.getRuntime().availableProcessors());
        
        //for (int i : array) System.out.println(i);
        //System.out.println("final result:  " + Arrays.toString(array));
        if (array[0] == 11) {
            System.out.println("Success!");
        }
    }
}
