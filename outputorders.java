import java.util.Scanner;

public class outputorders {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1;
        int num2;
        System.out.println("Enter number 1:");
        num1 = scan.nextInt();
        System.out.println("Enter number 2:");
        num2 = scan.nextInt();
        System.out.println(num1 + ", " + num2);
        System.out.println(num2 + ", " + num1);
    }
}