import java.util.LinkedList;

public class Problems {

    static void sortNumsBetween100s(int[] A) {
        // TODO
        int maxValue = A[0];
        for (int m = 1; m < A.length; m++) {
            if (A[m] > maxValue) {
                maxValue = A[m];
            }
        }
        int minValue = A[0];
        for (int m = 1; m < A.length; m++) {
            if (A[m] < minValue) {
                minValue = A[m];
            }
        }
//        System.out.println(minValue);
//        System.out.println(maxValue);
        int len = maxValue + Math.abs(minValue) + 1;
//        System.out.println(len);
        int[] count = new int[len];
        for(int e =0; e<A.length; e++){
            int ind = Math.abs(minValue-A[e]);
//            System.out.println(ind);
//            System.out.println(ind);
            count[ind]++; //= 1 + count[Math.abs(A[e])*2];
        }
        int i = 0;
        for (int j = 0; j < count.length; j++){
            while (count[j] > 0){
                A[i] = minValue + j;
                count[j]--;
                i++;
            }
        }

    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }


    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        // TODO
        LinkedList<String>[] L = new LinkedList[26];
        for (int i = 0; i < 26; i++) {
//            int df = getNthCharacter(A[i], 3);
//            System.out.println(A[i]);
//            System.out.println(df);

            L[i] = new LinkedList<>();
        }
        for (String i : A) {
            // TODO: Extract the relevant digit from i, and add i to the corresponding Linked List.
            int index = getNthCharacter( i , n);
            L[index].add(i);

        }
        int j = 0; // index in A to place numbers
        for (LinkedList<String> list : L) {
            // TODO: Put all numbers in the linked lists into A
            while(list.isEmpty() == false) {
                A[j] = list.remove();

                j++;
            }
        }
    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        // TODO
//        int k = getNthCharacter(S[0], 0) + 1;
//        for (int i = 1; i < S.length; i++){
//            k = (getNthCharacter(S[i],i) + 1 > k) ? getNthCharacter(S[i], i) + 1 : k;
//        }
        //int w = S[0].length(); //(int) Math.ceil(Math.log(k) / Math.log(b)); // w = log base b of k, word length of numbers
        // TODO: Perform radix sort
        for(int i = 0; i<stringLength; i++){
            countingSortByCharacter(S,i);
        }
    }

    /**
     * @param A The array to count swaps in
     */

    public static int countSwaps(int[] A) {
        // TODO
        return 0;
    }

}
