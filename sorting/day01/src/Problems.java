import java.util.*;

public class Problems {

    private static PriorityQueue<Integer> minPQ() {
        return new PriorityQueue<>(11);
    }

    private static PriorityQueue<Integer> maxPQ() {
        return new PriorityQueue<>(11, Collections.reverseOrder());
    }

    private static double getMedian(List<Integer> A) {
        double median = (double) A.get(A.size() / 2);
        if (A.size() % 2 == 0)
            median = (median + A.get(A.size() / 2 - 1)) / 2.0;
        return median;
    }

    // Runtime of this algorithm is O(N^2). Sad! We provide it here for testing purposes
    public static double[] runningMedianReallySlow(int[] A) {
        double[] out = new double[A.length];
        List<Integer> seen = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int j = 0;
            while (j < seen.size() && seen.get(j) < A[i])
                j++;
            seen.add(j, A[i]);
            out[i] = getMedian(seen);
        }
        System.out.println(Arrays.toString(out));
        return out;
    }


    /**
     *
     * @param inputStream an input stream of integers
     * @return the median of the stream, after each element has been added
     */
    public static double[] runningMedian(int[] inputStream) {
        double[] runMedian = new double[inputStream.length];
        // TODO

        if(inputStream.length == 0){return runMedian;}
        if(inputStream.length == 1){
            runMedian[0] = inputStream[0];
            return runMedian;}
        PriorityQueue<Integer> max = maxPQ();
        PriorityQueue<Integer> min = minPQ();
        double Med = inputStream[0];
        for(int i =0; i < inputStream.length; i++){
            //adding Element to max or min


            if(inputStream[i] <= Med){
                //System.out.println("hitmax");
                max.add(inputStream[i]);
            }else{
                min.add(inputStream[i]);
                //System.out.println("hitmin");
            }
//            System.out.println(max.size());
//            System.out.println(min.size());
            //checking size of min and max
            if(max.size() == min.size()+2){
                int temp = max.poll();
                min.add(temp); }
            if(min.size() == max.size()+2){
                int temp = min.poll();
                max.add(temp); }
            System.out.println(max.size());
            System.out.println(min.size());
            // change median
            if(min.size() == 0){Med = max.peek();
            //System.out.println("max");
            }
            else if(max.size()==0){Med = min.peek();
            //System.out.println("min");
            }
            else if(min.size() == max.size() ){
                Med = (( (double)max.peek() + (double)min.peek() )/2);
                System.out.println("equ");
            }else{
                Med = (max.size() > min.size())?max.peek():min.peek();
                System.out.println("gre");
            }
            runMedian[i] = Med;
            System.out.println("new");
        }
        //double[] daMedian = (double[]) Med;
        System.out.println(Arrays.toString(runMedian));
        return runMedian;
    }

}
