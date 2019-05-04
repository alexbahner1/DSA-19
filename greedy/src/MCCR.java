import java.util.Arrays;

public class MCCR {

    public static int MCCR(EdgeWeightedGraph G){
//
        boolean[] tested = new boolean[G.numberOfV()];
        int[] keys = new int[G.numberOfV()];
        Arrays.fill(keys, Integer.MAX_VALUE);
        keys[0] = 0;

        for (int i = 0; i < G.numberOfV(); i++){
            int v = minVer(tested,keys, G.numberOfV());
            tested[v] = true;
            Iterable<Edge> edges = G.edges(v);
            for (Edge e : edges) {
                int other = e.other(v);
                if (!tested[other]) {
                    keys[other] = (e.weight() < keys[other]) ? e.weight() : keys[other];
                }
            }
        }
        return sum(keys);
    }
    public static int minVer(boolean[] inGraph, int[] keys, int V) {
        int minVal = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < V; i++) {
            if (!inGraph[i] && keys[i] < minVal) {
                minVal = keys[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static int sum(int[] keys) {
        int sum = 0;
        for (int k : keys) {sum += k;}
        return sum;
    }
}
