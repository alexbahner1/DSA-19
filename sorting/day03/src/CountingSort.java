public class CountingSort {

    /**
     * Use counting sort to sort non-negative integer array A.
     * Runtime: TODO O(n +k) k is max
     * O(k)
     * if k is les then  nlogn
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        // TODO
        int maxValue = A[0];
        for (int m = 1; m < A.length; m++) {
            if (A[m] > maxValue) {
                maxValue = A[m];
            }
        }

        int[] count = new int[maxValue + 1];
        for(int e =0; e<A.length; e++){
            count[A[e]]++;
        }
        int i = 0;
        for (int j = 0; j < count.length; j++){
            while (count[j] > 0){
                A[i] = j;
                count[j]--;
                i++;
            }
        }
    }


}
