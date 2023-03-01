import java.util.Scanner;

public class gradeMark {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int mark;
        System.out.println("Please enter your mark:");
        mark = scan.nextInt();
        if (mark >= 0 && mark <= 29) {
            System.out.println("Grade F");
        } else if (mark >= 30 && mark <= 39) {
            System.out.println("Grade E");
        } else if (mark >= 40 && mark <= 49) {
            System.out.println("Grade D");
        } else if (mark >= 50 && mark <= 59) {
            System.out.println("Grade C");
        } else if (mark >= 60 && mark <= 69) {
            System.out.println("Grade B");
        } else if (mark >=70 && mark <= 89) {
            System.out.println("Grade A");
        } else if (mark >=90 && mark <= 100) {
            System.out.println("Grade A*");
        } else {
            System.out.println("Mark is invalid");
        }
        scan.close();
    }
}
