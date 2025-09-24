public class Introduction {
    public static void main(String[] args) {

        String name = "Nguyen Ngoc Anh Khoi";
        String studentId = "24020184";
        String className = "INT2204_4";
        String githubUser = "khoizz247";
        String email = "24020184@vnu.edu.vn";


        System.out.println(name + "\t" + studentId + "\t" + className + "\t" + githubUser + "\t" + email);


        for (int i = 9; i >= 1; i--) {
            if (i > 1) {
                System.out.println(i + " bottles of beer on the wall, " + i + " bottles of beer.");
                System.out.println("Take one down, pass it around,");
            } else {
                System.out.println(i + " bottle of beer on the wall, " + i + " bottle of beer.");
                System.out.println("Take one down, pass it around,");
                System.out.println("No more bottles of beer on the wall.");
            }
            System.out.println();
        }
    }
}
