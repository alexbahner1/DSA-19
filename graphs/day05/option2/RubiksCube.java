import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


// this is our implementation of a rubiks cube. It is your job to use A* or some other search algorithm to write a
// solve() function
public class RubiksCube {

    private BitSet cube;
<<<<<<< HEAD
<<<<<<< HEAD
    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;
    char[] options = new char[] {'u', 'U', 'r', 'R', 'f', 'F'};
=======
    private HashMap<Integer, HashMap<Integer, Integer>> distances;
>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
=======
>>>>>>> 977210869216e783e94af0f7faa4a7a916b08eb6

    // initialize a solved rubiks cube
    public RubiksCube() {
        // 24 colors to store, each takes 3 bits
<<<<<<< HEAD
<<<<<<< HEAD
        cube = new BitSet(24 * 3);
        for (int side = 0; side < 6; side++) {
            for (int i = 0; i < 4; i++) {
                setColor(side * 4 + i, side);
=======
        cube = new BitSet(24 * 5);
        for (int side = 0; side < 6; side++) {
            for (int i = 0; i < 4; i++) {
                setColor(side * 4 + i, side * 4 + i);
>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
=======
        cube = new BitSet(24 * 3);
        for (int side = 0; side < 6; side++) {
            for (int i = 0; i < 4; i++) {
                setColor(side * 4 + i, side);
>>>>>>> 977210869216e783e94af0f7faa4a7a916b08eb6
            }
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======
    public void populate_hm(){
        {0,19,22,}

        distances = new HashMap<>();
        for(int i = 0; i < 24; i++){
            HashMap<Integer, Integer> curr_distances = new HashMap<>()
            for(int j = 0; j < 24;j++){

            }
        distances.put(i, curr_distances);

        }
    }

>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
=======
>>>>>>> 977210869216e783e94af0f7faa4a7a916b08eb6
    // initialize a rubiks cube with the input bitset
    private RubiksCube(BitSet s) {
        cube = (BitSet) s.clone();
    }

    // creates a copy of the rubics cube
    public RubiksCube(RubiksCube r) {
        cube = (BitSet) r.cube.clone();
    }

    // return true if this rubik's cube is equal to the other rubik's cube
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RubiksCube))
            return false;
        RubiksCube other = (RubiksCube) obj;
        return other.cube.equals(cube);
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
        return cube.hashCode();
    }

    public boolean isSolved() {
        return this.equals(new RubiksCube());
    }


    // takes in 3 bits where bitset.get(0) is the MSB, returns the corresponding int
    private static int bitsetToInt(BitSet s) {
        int i = 0;
<<<<<<< HEAD
<<<<<<< HEAD
        if (s.get(0)) i |= 4;
        if (s.get(1)) i |= 2;
        if (s.get(2)) i |= 1;
=======
        if (s.get(0)) i |= 16;
        if (s.get(1)) i |= 8;
        if (s.get(2)) i |= 4;
        if (s.get(3)) i |= 2;
        if (s.get(4)) i |= 1;
>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
=======
        if (s.get(0)) i |= 4;
        if (s.get(1)) i |= 2;
        if (s.get(2)) i |= 1;
>>>>>>> 977210869216e783e94af0f7faa4a7a916b08eb6
        return i;
    }

    // takes in a number 0-5, returns a length-3 bitset, where bitset.get(0) is the MSB
    private static BitSet intToBitset(int i) {
<<<<<<< HEAD
<<<<<<< HEAD
        BitSet s = new BitSet(3);
=======
        BitSet s = new BitSet(5);
        if (i % 2 == 1) s.set(4, true);
        i /= 2;
        if (i % 2 == 1) s.set(3, true);
        i /= 2;
>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
=======
        BitSet s = new BitSet(3);
>>>>>>> 977210869216e783e94af0f7faa4a7a916b08eb6
        if (i % 2 == 1) s.set(2, true);
        i /= 2;
        if (i % 2 == 1) s.set(1, true);
        i /= 2;
        if (i % 2 == 1) s.set(0, true);
        return s;
    }

    // index from 0-23, color from 0-5
<<<<<<< HEAD
    private void setColor(int index, int color) {
        BitSet colorBitset = intToBitset(color);
        for (int i = 0; i < 3; i++)
            cube.set(index * 3 + i, colorBitset.get(i));
=======
    private void setColor(int index, int number) {
        BitSet colorBitset = intToBitset(number);
<<<<<<< HEAD
        for (int i = 0; i < 5; i++)
            cube.set(index * 5 + i, colorBitset.get(i));
>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
=======
        for (int i = 0; i < 3; i++)
            cube.set(index * 3 + i, colorBitset.get(i));
>>>>>>> 977210869216e783e94af0f7faa4a7a916b08eb6
    }


    // index from 0-23, returns a number from 0-5
    private int getColor(int index) {
<<<<<<< HEAD
<<<<<<< HEAD
        return bitsetToInt(cube.get(index * 3, (index + 1) * 3));
=======
        return bitsetToInt(cube.get(index * 5, (index + 1) * 5));
>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
=======
        return bitsetToInt(cube.get(index * 3, (index + 1) * 3));
>>>>>>> 977210869216e783e94af0f7faa4a7a916b08eb6
    }

    // given a list of rotations, return a rubik's cube with the rotations applied
    public RubiksCube rotate(List<Character> c) {
        RubiksCube rub = this;
        for (char r : c) {
            rub = rub.rotate(r);
        }
        return rub;
    }

<<<<<<< HEAD
=======

>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
    // Given a character in ['u', 'U', 'r', 'R', 'f', 'F'], return a new rubik's cube with the rotation applied
    // Do not modify this rubik's cube.
    public RubiksCube rotate(char c) {
        int[] faceFrom = null;
        int[] faceTo = null;
        int[] sidesFrom = null;
        int[] sidesTo = null;
        // colors move from the 'from' variable to the 'to' variable
        switch (c) {
            case 'u': // clockwise
            case 'U': // counterclockwise
                faceFrom = new int[]{0, 1, 2, 3};
                faceTo = new int[]{1, 2, 3, 0};
                sidesFrom = new int[]{4, 5, 8, 9, 17, 16, 21, 20};
                sidesTo = new int[]{21, 20, 4, 5, 8, 9, 17, 16};
                break;
            case 'r':
            case 'R':
                faceFrom = new int[]{8, 9, 10, 11};
                faceTo = new int[]{9, 10, 11, 8};
                sidesFrom = new int[]{6, 5, 2, 1, 17, 18, 13, 14};
                sidesTo = new int[]{2, 1, 17, 18, 13, 14, 6, 5};
                break;
            case 'f':
            case 'F':
                faceFrom = new int[]{4, 5, 6, 7};
                faceTo = new int[]{5, 6, 7, 4};
                sidesFrom = new int[]{3, 2, 8, 11, 14, 15, 23, 20};
                sidesTo = new int[]{8, 11, 14, 15, 23, 20, 3, 2};
                break;
            default:
                System.out.println(c);
                assert false;
        }
        // if performing a counter-clockwise rotation, swap from and to
        if (Character.isUpperCase(c)) {
            int[] temp;
            temp = faceFrom;
            faceFrom = faceTo;
            faceTo = temp;
            temp = sidesFrom;
            sidesFrom = sidesTo;
            sidesTo = temp;
        }
        RubiksCube res = new RubiksCube(cube);
        for (int i = 0; i < faceFrom.length; i++) res.setColor(faceTo[i], this.getColor(faceFrom[i]));
        for (int i = 0; i < sidesFrom.length; i++) res.setColor(sidesTo[i], this.getColor(sidesFrom[i]));
        return res;
    }

    // returns a random scrambled rubik's cube by applying random rotations
    public static RubiksCube scrambledCube(int numTurns) {
        RubiksCube r = new RubiksCube();
        char[] listTurns = getScramble(numTurns);
        for (int i = 0; i < numTurns; i++) {
            r= r.rotate(listTurns[i]);
        }
        return r;
    }

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

<<<<<<< HEAD
    // calculate manhattan distance
    public int manhattan(RubiksCube r) {
//        RubiksCube sol = new RubiksCube();
        int mandis = 0;
        for(int i = 0; i < 24; i++) {
            int tar = r.getColor(i);
            int cur = i / 4;
            if(Math.abs(tar-cur) == 3) { mandis += 2; }
            else if(Math.abs(tar-cur) != 0) {mandis++;}
        }
        return (int) (mandis / 8);
    }
=======

>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c


    // return the list of rotations needed to solve a rubik's cube
    public List<Character> solve() {
        // TODO
<<<<<<< HEAD
        State initState = new State(this,0,new ArrayList<>(),null);
        solutionState = new State(this,0,new ArrayList<Character>(),null);

        PriorityQueue<State> PQ = new PriorityQueue<>();

        PQ.add(initState);



        HashSet< RubiksCube> visted = new HashSet<>();




        visted.add( initState.cube);


        while (!PQ.isEmpty()){
            State curr = PQ.poll();


            if(curr.cube.isSolved()){
//               Base case: return the path if goal is reached
                solutionState = curr;
                minMoves = curr.moves;
                solved = true;
//                System.out.println("you got it");
                // want to be able to return a list of previous moves
                while(curr.prev == null){

                    curr.prev = curr.prev;
                }
                return curr.rotations;
            }


            RubiksCube temp = curr.cube;

            int ic = 0;
            for(RubiksCube n: getNeighbors(curr.cube)){
                //System.out.println(n.cube.toString());
                State next = new State(n,curr.moves+1,curr.rotations, curr);
                next.rotations.add(options[ic]);
                ic++;
                if(!visted.contains(n)){
                    PQ.add(next);
                    visted.add(n);
                }
            }
        }
        return new ArrayList<>();
    }

    private Iterable<RubiksCube> getNeighbors(RubiksCube r) {
        LinkedList<RubiksCube> n = new LinkedList<>();
        // double check that this is ok
        RubiksCube temp = r;
       // {'u', 'U', 'r', 'R', 'f', 'F'};
//        RubiksCube temp1 = r.rotate('u');
//        RubiksCube temp2 = r.rotate('U');
//        RubiksCube temp3 = r.rotate('r');
//        RubiksCube temp4 = r.rotate('R');
//        RubiksCube temp5 = r.rotate('f');
//        RubiksCube temp6 = r.rotate('F');
//        n.add(temp1); n.add(temp2); n.add(temp3); n.add(temp4); n.add(temp5); n.add(temp6);
        for(char i : options){
            temp = r.rotate(i);
            n.add(temp);
        }
        return n;
    }

    private class State implements Comparable<State>{
        // Each state needs to keep track of its cost and the previous state
        private RubiksCube cube;
        private int moves; // equal to g-cost in A*
        public int cost; // equal to f-cost in A*
        public List<Character> rotations;
        private State prev;

        public State(RubiksCube cube, int moves, List<Character> rotations, State prev) {
            this.cube = cube;
            this.moves = moves;
            this.rotations = new ArrayList<Character>(rotations);
            this.prev = prev;
            // TODO
            cost = moves + cube.manhattan(cube) ;
        }

        @Override
        public boolean equals(Object s) {
            if (s == this) return true;
            if (s == null) return false;
            if (!(s instanceof State)) return false;
            return ((State) s).cube.equals(this.cube);
        }

        public int compareTo(State s) {
            return this.cost - s.cost;
        }

        @Override
        public int hashCode() {
            return this.cube.hashCode();
        }
    }

    public static void main(String[] args){
        RubiksCube cube = new RubiksCube();
//        manhattan(cube);
    }
=======
        return new ArrayList<>();
    }

>>>>>>> 14343db58a6c6468c44ca7fdf45b96abbe17b18c
}