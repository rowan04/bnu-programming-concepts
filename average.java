import java.util.Scanner;

public class average {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num1;
        double num2;
        System.out.println("Enter number 1:");
        num1 = scan.nextDouble();
        System.out.println("Enter number 2:");
        num2 = scan.nextDouble();
        double average = (num1 + num2)/2;
        System.out.println("The average is: " + average);
        scan.close();
    }
}
