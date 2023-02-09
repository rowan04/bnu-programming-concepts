import java.util.Scanner;

public class timestable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num;
        System.out.println("Which times table would you like to see? (Enter an integer):");
        num = scan.nextInt();
        System.out.println("Here is the " + num + " times table:");
        int count = 1;
        while (count<=12) {
            System.out.println(count + " x " + num + " = " + (count*num));
            count = count + 1;
        }
    }
}
