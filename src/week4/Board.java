import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class Board {

    private int n;
    private int[][] board;

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
        if (y == this) {
            return true;
        }
        if (y == null) {
            return false;
        }
        if (y.getClass() != this.getClass()) {
            return false;
        }

        Board board = (Board) y;

        if (this.dimension() != board.dimension()) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.board[i][j] != board.board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        ArrayQueue<Board> queue = new ArrayQueue<>();
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
        int[][] twin = copy(board);

        // int xi = StdRandom.uniform(0, n);
        // int xj = StdRandom.uniform(0, n);
        // int yi = StdRandom.uniform(0, n);
        // int yj = StdRandom.uniform(0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int xi = StdRandom.uniform(0, n);
                int xj = StdRandom.uniform(0, n);
                int yi = StdRandom.uniform(0, n);
                int yj = StdRandom.uniform(0, n);
                if ((xi == yi) && (xj == yj)) {
                    continue;
                }

                if (twin[xi][xj] == 0) {
                    System.out.println("test " + twin[xi][xj]);
                    continue;
                }
                swap(twin, xi, xj, yi, yj);

            }
        }
        Board b = new Board(twin);
        System.out.println(b.toString());

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
        int[][] tils = new int[][] {
                { 0, 1, 2 },
                { 3, 4, 5 },
                { 6, 7, 8 },

        };
        int[][] tilz = new int[][] {
                { 2, 1, 0 },
                { 3, 4, 5 },
                { 6, 7, 8 },

        };
        int[][] tilze = new int[][] {
                { 2, 1, 6 },
                { 3, 4, 5 },
                { 0, 7, 8 },

        };

        int[][] tlze = new int[][] {
                { 3, 5, 1 },
                { 0, 4, 7 },
                { 2, 6, 8 },

        };

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // tiles[i][j] = n * i + j;
        // }
        // }
        Board board = new Board(tlze);
        System.out.println(Arrays.deepToString(tile));
        System.out.println(board.toString());
        System.out.println(board.hamming());
        System.out.println(board.manhattan());
        System.out.println(board.isGoal());
        System.out.println(board.neighbors());
        System.out.println(board.twin());

        // for (Board neighbor : board.neighbors()) {
        // System.out.println(neighbor);
        // }

    }

}
