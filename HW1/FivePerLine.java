public class FivePerLine {
    public static void main(String[] args) {
        int start = 1000;
        int end = 2000;
        int PER_LINE = 5;
        for (int i=start; i<=end; i++) {
            System.out.print(i + " ");
            if ((i + 1) % PER_LINE == 0) System.out.println();
        }

    }
}