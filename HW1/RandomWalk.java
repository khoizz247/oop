import java.util.Scanner;

public class RandomWalk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.enableDoubleBuffering();

        int x = 0, y = 0;
        int steps = 0;


        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int dirIndex = 0;
        int stepSize = 1;
        int movedInDir = 0;
        int changeCount = 0;

        while (Math.abs(x) < n && Math.abs(y) < n) {

            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(x, y, 0.45);


            x += dirs[dirIndex][0];
            y += dirs[dirIndex][1];
            steps++;
            movedInDir++;


            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.filledSquare(x, y, 0.45);
            StdDraw.show();
            StdDraw.pause(40);


            if (movedInDir == stepSize) {
                dirIndex = (dirIndex + 1) % 4;
                movedInDir = 0;
                changeCount++;

                if (changeCount == 2) {
                    stepSize++;
                    changeCount = 0;
                }
            }
        }

        StdOut.println("Total steps = " + steps);
    }
}
