import java.util.Scanner;

public class interest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final double INTEREST = 0.01;
        int money;
        System.out.println("Please enter the amout of money you are investing:");
        money = scan.nextInt();
        double savings = money + (money * INTEREST);
        System.out.println("You will save: " + savings);
    }
}
