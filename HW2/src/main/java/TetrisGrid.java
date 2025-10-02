//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean[][] grid;

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }


    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        int height = grid[0].length;
        int width = grid.length;
        for (int y = 0; y < height; y++) {
            boolean check = true;
            for (int x = 0; x < width; x++) {
                if (!grid[x][y]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                for (int k = y; k < height - 1; k++) {
                    for (int l = 0; l < width; l++) {
                        this.grid[l][k] = this.grid[l][k + 1];
                    }
                }
                for (int k = 0; k < width; k++) {
                    grid[k][height - 1] = false;
                }
                y--;
            }
        }
    }

    /**
     * Returns the internal 2d grid array.
     *
     * @return 2d grid array
     */
    boolean[][] getGrid() {
        return this.grid;
    }
}
