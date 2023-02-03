import java.util.Scanner;

public class age {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age;
        String birthdayThisYear;
        System.out.println("Please enter your age:");
        age = scan.nextInt();
        System.out.println("Has it been your birthday this year?");
        birthdayThisYear = scan.next();
        if ("Yes".equals(birthdayThisYear)) {
            int birthyear = 2023 - age;
            System.out.println("You were born in " + birthyear);
        } else {
            int birthyear = 2023 - age - 1;
            System.out.println("You were born in " + birthyear);
        }
    }
}
