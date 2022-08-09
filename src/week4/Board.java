import java.util.Arrays;

public class Board {

    private int n;
    private int[][] board;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {

        n = tiles.length;
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = tiles[i][j];
            }
        }
    }

    // string representation of this board
    public String toString() {
        String dim = String.valueOf(n);
        String string = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String temp = String.valueOf(board[i][j]);
                string = string + " " + temp;
            }
            string = string + "\n";
        }
        return dim + "\n" + string;
    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        int distance = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = n * i + j;
                if (board[i][j] != k + 1) {
                    distance++;
                }
            }
        }
        return distance - 1;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int distance = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = n * i + j;
                if (board[i][j] != k + 1) {
                    if (board[i][j] == 0) {
                        continue;
                    }
                    int goalI = (board[i][j] - 1) / n;
                    int goalJ = (board[i][j] - 1) % n;
                    int hor = Math.abs(goalI - i);
                    int ver = Math.abs(goalJ - j);
                    distance += hor + ver;
                }
            }
        }
        return distance;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {

        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        return null;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        return null;
    }

    // unit testing (not graded)
    public static void main(String[] args) {

        int n = 3;
        int[][] tiles = new int[][] {
                { 8, 1, 3 },
                { 4, 0, 2 },
                { 7, 6, 5 },

        };
        int[][] tile = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 0 },

        };

        int[][] til = new int[][] {
                { 1, 0, 3 },
                { 4, 5, 6 },
                { 7, 8, 2 },

        };

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // tiles[i][j] = n * i + j;
        // }
        // }
        Board board = new Board(tile);
        System.out.println(Arrays.deepToString(tile));
        System.out.println(board.toString());
        System.out.println(board.hamming());
        System.out.println(board.manhattan());
        System.out.println(board.isGoal());

    }

}
