package app.domain.model;

import java.util.Arrays;

/**
 * The type Benchmark.
 */
public class Benchmark {
    /**
     * Max int [ ].
     *
     * @param seq the seq
     * @return the int [ ]
     */
    public static int[] max(int[] seq) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int startMaxSoFar = 0;
        int endMaxSoFar = 0;
        int startMaxEndingHere = 0;
        for (int i = 0; i < seq.length; ++i) {
            final int elem = seq[i];
            final int endMaxEndingHere = i + 1;
            if (maxEndingHere + elem < 0) {
                maxEndingHere = 0;
                startMaxEndingHere = i + 1;
            }
            else {
                maxEndingHere += elem;
            }
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                startMaxSoFar = startMaxEndingHere;
                endMaxSoFar = endMaxEndingHere;
            }
        }
        return Arrays.copyOfRange(seq, startMaxSoFar, endMaxSoFar);
    }

    /**
     * Sum int.
     *
     * @param seq the seq
     * @return the int
     */
    public int sum(int[] seq){
        int counter = 0;
        for (int i = 0; i < seq.length; i++) {
            counter += seq[i];
        }
        return counter;
    }
}
