import java.util.ArrayList;
import java.util.HashMap;

public class FrequencyPrint {

    static String frequencyPrint(String s) {
        // TODO

        // This  split the string into a array.
        String[] sArray = s.split(" ");
        //System .out.println(sarray.length);

        // make hash map get frequency
        ArrayList<String> words = new ArrayList<>();
        HashMap<String, Integer> StoImap = new HashMap<>();
        for (int i =0; i < sArray.length; i++){
            if(StoImap.get(sArray[i]) == null){
                StoImap.put(sArray[i],1);
                words.add(sArray[i]);
            }else{
                StoImap.put(sArray[i], StoImap.get(sArray[i])+1);
            }
        }

        //System.out.println(StoImap.get(sArray[3]));
        //more to a new hashmap to make them diffent
        HashMap<Integer, String> ItoSmap = new HashMap<>();
        int max = 0;
        for(int j  = 0; j < words.size(); j++) {
            int key = StoImap.get(words.get(j));
            if(key > max){max = key;}
            //System.out.println(key);
            for (int jj = 0; jj < key; jj++){
                if (ItoSmap.get(key) == null) {
                    ItoSmap.put(key,words.get(j) + " ");
                } else {
                    ItoSmap.put(key, ItoSmap.get(key) + words.get(j) + " ");
                }
            }

        }
        String fids = "";
        for(int i =0; i<=max; i++){
            if(ItoSmap.get(i) != null){
                fids = fids + ItoSmap.get(i);
                //System.out.println(max);
            }
        }
//        System.out.println(words.get(0));
//        System.out.println(StoImap.get(words.get(0)));
//        System.out.println(ItoSmap.get(2));
        System.out.println(fids);
        return fids;
    }

}
