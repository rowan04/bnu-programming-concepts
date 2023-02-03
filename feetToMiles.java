import java.util.Scanner;

public class feetToMiles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int FEET_IN_MILES = 5280;
        double feet;
        System.out.println("Please enter the number of feet to convert to miles:");
        feet = scan.nextDouble();
        double inMiles = feet / FEET_IN_MILES;
        System.out.println("That is " + inMiles + " miles.");
    }
}