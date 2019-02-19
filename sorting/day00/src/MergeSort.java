import java.util.Arrays;

public class MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * TODO
     * Best-case runtime: O(nlog(n))
     * Worst-case runtime: O(nlog(n))
     * Average-case runtime: O(nlog(n))
     *
     * Space-complexity: O(n)
     */
    @Override
    public int[] sort(int[] array) {
        // TODO
        if(array.length < 2){return array;}
        int[] a = Arrays.copyOfRange(array,0,array.length/2);
        //System.out.println(a);
        int[] b = Arrays.copyOfRange(array,array.length/2, array.length);
        //System.out.println(b);
        int[] left = sort(a);
        int[] right = sort(b);
        array = merge(left, right);

        return array;
    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {
        // TODO
        int[] c = new int[a.length+b.length];
        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length){
            if(a[i] > b[j]){
                c[i+j] = b[j];
                j++;
            }
            else{
                c[i+j] = a[i];
                i++;
            }
        }
        for(int g=i+j; g<c.length; g++){
            if(i !=a.length){ c[g] = a[i]; i++;}
            if(j !=b.length){ c[i+j] = b[j]; j++;}
        }
        return c;
    }

}
