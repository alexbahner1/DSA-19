import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // Runtime: TODO
    // Space: TODO
    public static int LIS(int[] A) {
        // TODO
        int[] DP = new int[A.length];
        for(int i = 0; i < DP.length; i++){DP[i] = 0;}
        return  help(A,DP);

    }
//    public static int help(int[] a, int max) {
//        int l = 0;
//        while (l < a.length) {
//            int curr = a[l];
//            int co = 0;
//            for (int i = l; i < a.length; i++) {
//                if (curr < a[i]) {
//                    co++;
//                    curr = a[i];
//                }
//            }
//            if (co > max) {
//                max = co;
//            }
//            l++;
//        }
//
//        return max;
//
//    }

    public static int help(int[] a, int[] dp) {

        if(a.length ==0 ){return 0;}
        int l = a.length-1;
//        dp[a.length-1] = 1;
        while (l >= 0) {
//        for (int l = a.length - 1; l >= 0; l--) {
            int c = l +1;
            while(c < a.length){
//            for (int c = l + 1; c < a.length; c++) {
//                System.out.println(a[l]);
//                System.out.println(a[c]);
                if(a[l] < a[c]){

                    if (dp[l]-1 < dp[c]) {
                        dp[l] = dp[c] + 1;

                    }
                }
                c++;
            }
            l--;
        }
        int max = 0;
        for(int i : dp){
           if(i > max){max=i;}
        }
        System.out.println(Arrays.toString(dp));
        return max + 1;
    }
}