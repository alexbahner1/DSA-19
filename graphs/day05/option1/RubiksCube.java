<<<<<<< HEAD
import java.lang.reflect.Array;
=======
>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

// use this class if you are designing your own Rubik's cube implementation
public class RubiksCube {
<<<<<<< HEAD
    public HashMap<String, int[]> faces;
=======
>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c

    // initialize a solved rubiks cube
    public RubiksCube() {
        // TODO
<<<<<<< HEAD
        HashMap<String, int[]> faces = new HashMap<>();
        String[] names = new String []{"front", "back", "left", "right", "top", "bottom"};
        for(int i=0; i< 6; i++){
            int[] temp = new int[]{i,i,i,i};
            faces.put(names[i], temp);
        }

        this.faces = faces;
    }

    public static void printCube(HashMap<String, int[]> faces){
        String[] names = new String []{"front", "back", "left", "right", "top", "bottom"};
//        for(int i=0; i< 6; i++){
//            faces.get()
//            System.out.println();
//        }
        for(Map.Entry i: faces.entrySet()){
            int[] temp = (int[]) i.getValue();
            String s = new String();
            for(int j:temp){
                s = s + j + ",";
            }
//            StringBuilder temp = StringBuilder(i.getValue());
            System.out.println(i.getKey() + ":" + s);
        }

    }
=======
    }


>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
    // creates a copy of the rubics cube
    public RubiksCube(RubiksCube r) {
        // TODO
    }

    // return true if this rubik's cube is equal to the other rubik's cube
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RubiksCube))
            return false;
        RubiksCube other = (RubiksCube) obj;
        // TODO
        return false;
    }

    /**
     * return a hashCode for this rubik's cube.
     *
     * Your hashCode must follow this specification:
     *   if A.equals(B), then A.hashCode() == B.hashCode()
     *
     * Note that this does NOT mean:
     *   if A.hashCode() == B.hashCode(), then A.equals(B)
     */
    @Override
    public int hashCode() {
        // TODO
        return 0;
    }

    public boolean isSolved() {
        // TODO
<<<<<<< HEAD
        String[] names = new String []{"front", "back", "left", "right", "top", "bottom"};

        if (faces.get(names[1]) != faces.get(name [1])){return false;}
        for(){}
        if (faces.get(names[2]) != faces.get(name [2])){return false;}
        if (faces.get(names[3]) != faces.get(name [3])){return false;}
        if (faces.get(names[4]) != faces.get(name [4])){return false;}
        if (faces.get(names[5]) != faces.get(name [5])){return false;}
        if (faces.get(names[6]) != faces.get(name [6])){return false;}
    }
        return false;

=======
        return false;
    }
>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c


    // given a list of rotations, return a rubik's cube with the rotations applied
    public RubiksCube rotate(List<Character> c) {
        RubiksCube rub = this;
        for (char r : c) {
            rub = rub.rotate(r);
        }
        return rub;
    }


    // Given a character in ['u', 'U', 'r', 'R', 'f', 'F'], return a new rubik's cube with the rotation applied
    // Do not modify this rubik's cube.
    public RubiksCube rotate(char c) {
        // TODO
        return this;
    }

    // returns a random scrambled rubik's cube by applying random rotations
    public static RubiksCube scrambledCube(int numTurns) {
        RubiksCube r = new RubiksCube();
        char[] listTurns = getScramble(numTurns);
        for (int i = 0; i < numTurns; i++) {
            r = r.rotate(listTurns[i]);
        }
        return r;
    }
<<<<<<< HEAD
    public void rotrightclock(){
        String[] names = new String []{"front", "back", "left", "right", "top", "bottom"};
        faces
        int[] list = (int[]) faces.get(names[4])[1];

        int temp1 = names[4].getValue()[1];

    }
}
=======
>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c

    public static char[] getScramble(int size){
        char[] listTurns = new char[size];
        for (int i = 0; i < size; i++) {
            switch (ThreadLocalRandom.current().nextInt(0, 6)) {
                case 0:
                    listTurns[i] = 'u';
                    break;
                case 1:
                    listTurns[i] = 'U';
                    break;
                case 2:
                    listTurns[i] = 'r';
                    break;
                case 3:
                    listTurns[i] = 'R';
                    break;
                case 4:
                    listTurns[i] = 'f';
                    break;
                case 5:
                    listTurns[i] = 'F';
                    break;
            }
        }
        return listTurns;
    }


    // return the list of rotations needed to solve a rubik's cube
    public List<Character> solve() {
        // TODO
        return new ArrayList<>();
    }

<<<<<<< HEAD
    public static void main(String[] args){
        RubiksCube cube = new RubiksCube();

        printCube(cube.faces);
    }
=======
}



>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
