import java.util.Scanner;

public class age {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age;
        String birthdayThisYear;
        System.out.println("Please enter your age:");
        age = scan.nextInt();
        if (age >= 18) {
            System.out.println("You are an adult!");
        } else {
            System.out.println("You are a child.");
        }
        System.out.println("Has it been your birthday this year?");
        birthdayThisYear = (scan.next().toLowerCase());
        if ("yes".equals(birthdayThisYear)) {
            int birthyear = 2023 - age;
            System.out.println("You were born in " + birthyear);
        } else if ("no".equals(birthdayThisYear)) {
            int birthyear = 2023 - age - 1;
            System.out.println("You were born in " + birthyear);
        } else {
            System.out.println("Invalid answer.");
        }
        scan.close();
    }
}
