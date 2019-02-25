import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TripleSum {

    static int tripleSum(int arr[], int sum) {
        // TODO
       int num = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            int ll = i+1;
            int hh = arr.length-1;
            while(ll<hh){
                if(arr[i]+arr[ll]+arr[hh] == sum){
                    num++;
                    ll++;
                    hh--;
                }else if(arr[i]+arr[ll]+arr[hh] < sum){
                    ll++;
                }else{ hh--;}
            }
        }
        return  num;
    }
}
