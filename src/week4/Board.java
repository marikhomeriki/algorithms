import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Queue;

public class Board {

    private final int n;
    private final int[][] board;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {

        if (tiles == null) {
            throw new IllegalArgumentException();
        }

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
        StringBuilder builder = new StringBuilder();

        builder.append(n);
        builder.append("\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                builder.append(" ");
                builder.append(board[i][j]);
            }
            builder.append("\n");
        }

        return builder.toString();
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
        if (y == this) {
            return true;
        }
        if (y == null) {
            return false;
        }
        if (y.getClass() != this.getClass()) {
            return false;
        }

        Board that = (Board) y;

        if (this.dimension() != that.dimension()) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.board[i][j] != that.board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Queue<Board> queue = new Queue<>();
        int emptyI = -1;
        int emptyJ = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    emptyI = i;
                    emptyJ = j;
                }
            }
        }
        if (emptyI == -1 || emptyJ == -1) {
            return queue;
        }

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((Math.abs(i) + Math.abs(j)) > 1 || (Math.abs(i) + Math.abs(j)) == 0) {
                    continue;
                }

                if ((emptyJ - j) < 0 || (emptyI - i) < 0) {
                    continue;
                }

                if ((emptyJ - j) >= n || (emptyI - i) >= n) {
                    continue;
                }

                int[][] copy = copy(board);

                swap(copy, emptyI, emptyJ, emptyI - i, emptyJ - j);
                Board neighbor = new Board(copy);
                queue.enqueue(neighbor);
            }
        }

        return queue;
    }

    private static int[][] copy(int[][] original) {

        int n = original.length;
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = original[i][j];
            }
        }

        return copy;
    }

    private static void swap(int[][] a, int xi, int xj, int yi, int yj) {
        int temp = a[xi][xj];
        a[xi][xj] = a[yi][yj];
        a[yi][yj] = temp;

    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int[][] twinTiles = copy(board);

        if (twinTiles[0][0] != 0 && twinTiles[0][1] != 0) {
            swap(twinTiles, 0, 0, 0, 1);
        } else {
            swap(twinTiles, 1, 0, 1, 1);
        }

        return new Board(twinTiles);

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 5, 1 },
                { 0, 4, 7 },
                { 2, 6, 8 },
        };

        Board board = new Board(matrix);
        System.out.println(board.toString());
        // System.out.println(board.hamming());
        // System.out.println(board.manhattan());
        // System.out.println(board.isGoal());
        // System.out.println(board.neighbors());
        // System.out.println(board.twin());
    }

}
