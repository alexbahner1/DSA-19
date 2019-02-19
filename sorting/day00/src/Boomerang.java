import java.util.HashMap;
import java.util.Map;

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
        // TODO
        int Booms = 0;
        //HashMap<double,int> distval = new HashMap<double,int>();
        for(int i = 0; i < points.length; i++){
            HashMap<Integer,Integer> distval = new HashMap<Integer,Integer> ();
            for(int j =0; j<points.length; j++){
                int x1 = points[i][0]; int x2 = points[j][0];
                int y1 = points[i][1]; int y2 = points[j][1];
                int dist = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
                if (distval.containsKey(dist)){
                    distval.put(dist,1+ distval.get(dist));
                } else{
                    distval.put(dist,1);
                }

            }

            for(Map.Entry<Integer,Integer> entry : distval.entrySet()) {
                //String key = entry.getKey();
                Integer val = entry.getValue();
                //System.out.println(val);
                Booms +=  (val*(val-1));
                // do what you have to do here
                // In your case, another loop.
            }

        }

        return Booms;
    }
}

