// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

import sun.java2d.windows.GDIBlitLoops;

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        char[][] tempGrid = this.grid;
        int rows = tempGrid.length;
        int cols = tempGrid[0].length;
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxRow = -1;
        int maxCol = -1;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (tempGrid[i][j] == ch) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                    count++;
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        if (count == 1) {
            return 1;
        }
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }


    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */

    private int checkChieuDaiNhanh(int i, int j, int di, int dj, char c) {
        int len = 0;
        int x = i + di;
        int y = j + dj;
        while (x >= 0 && y >= 0 && x < this.grid.length && y < this.grid[0].length && this.grid[x][y] == c) {
            x += di;
            y += dj;
            len++;
        }
        return len;
    }

    private boolean laNhanh(int i, int j) {
        char ch = this.grid[i][j];
        int up = checkChieuDaiNhanh(i, j, -1, 0, ch);
        int down = checkChieuDaiNhanh(i, j, 1, 0, ch);
        int left = checkChieuDaiNhanh(i, j, 0, -1, ch);
        int right = checkChieuDaiNhanh(i, j, 0, 1, ch);
        int min = Math.min(Math.min(up, right), Math.min(down, left));
        return min >= 2;
    }

    public int countPlus() {
        int rows = this.grid.length;
        int cols = this.grid[0].length;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (laNhanh(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

}
