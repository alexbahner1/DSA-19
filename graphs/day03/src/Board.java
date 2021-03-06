import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Board definition for the 8 Puzzle challenge
 */
public class Board {

    private int n;
    public int[][] tiles;

    //TODO
    // Create a 2D array representing the solved board state
    private int[][] goal = {{}};

    /*
     * Set the global board size and tile state
     */
    //private int[][] goal = {{1,2,3},{4,5,6},{7,8,0}};

    public Board(int[][] b) {
        // TODO: Your code here
        tiles = b;
        n = b.length;

    }

    /*
     * Size of the board 
     (equal to 3 for 8 puzzle, 4 for 15 puzzle, 5 for 24 puzzle, etc)
     */
    private int size() {
        // TODO: Your code here
        return n;
    }

    /*
     * Sum of the manhattan distances between the tiles and the goal
     */
    public int manhattan() {
        // TODO: Your code here
        int manhattanDistances = 0;

        for (int i =0; i < n; i++) {
            for (int j=0; j < n; j++) {
                int value = tiles[i][j];
                if (tiles[i][j] != 0) {
                    int x = (value - 1) / n;
                    int y = (value - 1) % n;

                    int distance = (Math.abs(i-x)) + (Math.abs(j-y));
                    manhattanDistances = manhattanDistances + distance;

                }
            }
        }

        return manhattanDistances;
    }

    /*
     * Compare the current state to the goal state
     */
    public boolean isGoal() {
        // TODO: Your code here
        if (manhattan() == 0) {
            return true;
        }
        return false;
    }

    /*
     * Returns true if the board is solvable
     * Research how to check this without exploring all states
     */
    public boolean solvable() {
        // TODO: Your code here
        int inversions = 0;
        int l = n*n;

        for (int i = 0; i < l; i++){
            int xi = (i) / n;
            int yi = (i) % n;

            for(int j = i + 1; j < l; j++){


                int xj = (j) / n;
                int yj = (j) % n;

//                System.out.println(tiles[xi][yi]);
//                System.out.println(tiles[xj][yj]);




                if(tiles[xj][yj] < tiles[xi][yi] && tiles[xj][yj] != 0) {
                    inversions++;
//                    System.out.println("yes");
                }
//                System.out.println(" ");


            }
        }
//        System.out.println(inversions);
        if(inversions % 2 == 0 ){
            System.out.print("Yes!");
            return true;
        } else{
            return false;
        }
    }

    /*
     * Return all neighboring boards in the state tree
     */
    public Iterable<Board> neighbors() {
        // TODO: Your code here

        List<Board> neighboorList = new ArrayList<>();

        int[] gh = blankSpace(tiles);
        int x = gh[0];
        int y = gh[1];


        if(x > 0){
            //swap up
            int[][] temp = copyTiles(tiles);
            int move = temp[x-1][y];
            temp[x-1][y]  = temp[x][y];
            temp[x][y] = move;

            Board k = new Board(temp);
            neighboorList.add(k);


        }
        if(x < 2){
            //swap down
            int[][] temp = copyTiles(tiles);
            int move = temp[x+1][y];
            temp[x+1][y]  = temp[x][y];
            temp[x][y] = move;

            Board k = new Board(temp);
            neighboorList.add(k);
        }
        if(y > 0){
            //sawp left
            int[][] temp = copyTiles(tiles);
            int move = temp[x][y-1];
            temp[x][y-1]  = temp[x][y];
            temp[x][y] = move;

            Board k = new Board(temp);
            neighboorList.add(k);
        }
        if(y < 2){
            //swap right
            int[][] temp = copyTiles(tiles);
            int move = temp[x][y+1];
            temp[x][y+1]  = temp[x][y];
            temp[x][y] = move;

            Board k = new Board(temp);
            neighboorList.add(k);

        }



        return neighboorList;
    }
    public int[][] copyTiles(int[][] board) {
        int [][] newBoard = new int[board.length][];
        for(int i = 0; i < board.length; i++)
            newBoard[i] = board[i].clone();

        return newBoard;
    }

    private int[] blankSpace(int[][] board) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] == 0) {
                    int[] gh = new int[2];
                    gh[0]=i; gh[1]=j;

                    return gh;
                }

            }
        }
        return null;
    }
    /*
     * Check if this board equals a given board state
     */
    @Override
    public boolean equals(Object x) {
        // Check if the board equals an input Board object
        if (x == this) return true;
        if (x == null) return false;
        if (!(x instanceof Board)) return false;
        // Check if the same size
        Board y = (Board) x;
        if (y.tiles.length != n || y.tiles[0].length != n) {
            return false;
        }
        // Check if the same tile configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != y.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can include whatever output you find useful
        int[][] initState = {{1, 2, 3}, {4, 0, 6}, {7, 8, 5}};
        Board board = new Board(initState);

        System.out.println("Size: " + board.size());
        System.out.println("Solvable: " + board.solvable());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("Is goal: " + board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
    }
}
