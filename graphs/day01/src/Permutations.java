<<<<<<< HEAD
import java.util.*;
=======
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
>>>>>>> d26023a67aa5d4ee167cbfd4254484f332e69616

public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        // TODO
        List<List<Integer>> permutations = new LinkedList<>();
<<<<<<< HEAD
        //LinkedList<Integer> unused = new LinkedList<>();
        Set<Integer> unused = new HashSet<Integer>(A);
        LinkedList<Integer> current = new LinkedList<>();
        //for(int i : A){unused.add(i);}
        helper(current, unused, permutations);

//        for(int i = 0; i < permutations.size(); i++){
//            for(int j: permutations.get(i)){System.out.print(permutations.get(i).size());}
//            System.out.println("  --");
//
//        }

        //for(int i: permutations.get(1)){System.out.print(i);}
        System.out.println(permutations.size());
        //for(int i: permutations.get(permutations.size() -1)){System.out.print(i);}
        return permutations;
    }

    public  static void helper(LinkedList<Integer> current, Set<Integer> unused, List<List<Integer>> permutation){
        if (unused.size() < 1){

            permutation.add(new LinkedList<Integer>(current));
            //System.out.println("hit base");
            //for(int i: permutation.get(permutation.size() -1)){System.out.print(i);}
            //System.out.println(permutation.get(0).size());
            return;
        } //base case

        for(int i : new LinkedList<Integer>(unused)){
            //System.out.println(i);
            current.addFirst(i);
            unused.remove(i);
            //System.out.println("hit");
            //System.out.println(current.size());
            helper(current, unused, permutation);
            //System.out.println("hits");
            //System.out.println(current.size());
            //int last = current.size() -1;
            current.removeFirst();
            unused.add(i);

        }
    }

=======
        return permutations;
    }

>>>>>>> d26023a67aa5d4ee167cbfd4254484f332e69616
}
