import java.util.concurrent.ThreadLocalRandom;

public class QuickSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;
    private void shuffleArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int randIndex = ThreadLocalRandom.current().nextInt(i+1);
            swap(array, i, randIndex);
        }
    }

    /**
     * TODO
     * Best-case runtime:
     * Worst-case runtime:
     * Average-case runtime:
     *
     * Space-complexity:
     */
    @Override
    public int[] sort(int[] array) {
        // TODO: Sort the array. Make sure you avoid the O(N^2) runtime worst-case
        shuffleArray(array);
        quickSort(array,0,array.length-1);
        return array;

    }

    /**
     * Partition the array around a pivot, then recursively sort the left and right
     * portions of the array. A test for this method is provided in `SortTest.java`
     * Optional: use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * @param lo The beginning index of the subarray being considered (inclusive)
     * @param hi The ending index of the subarray being considered (inclusive)
     */
    public void quickSort(int[] a, int lo, int hi) {
//        for(int i = 0; i < a.length; i++){
//            System.out.println(a[i]);
//        }
        if(lo == hi){return;}
        if (lo < hi) {
            //System.out.println(" b ");
            int p = partition(a, lo, hi);
            quickSort(a, lo,p-1 );
            quickSort(a, p+1, hi);
            // TODO
        }
    }


    /**
     * Given an array, choose the array[low] element as the "pivot" element.
     * Place all elements smaller than "pivot" on "pivot"'s left, and all others
     * on its right. Return the final position of "pivot" in the partitioned array.
     *
     * @param lo The beginning index of the subarray being considered (inclusive)
     * @param hi The ending index of the subarray being considered (inclusive)
     */
    public int partition(int[] array, int lo, int hi) {
        // TODO


        while(lo < hi){
            if(array[hi] < array[lo]){

                swap(array, lo+1, hi);
                swap(array, lo, lo+1);
                lo++;
            }
            if(array[hi] >= array[lo]){ hi--;}


        }
        return lo;
    }

}
