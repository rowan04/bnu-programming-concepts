import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class daysalive {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your Date of Birth YYYY-MM-DD: ");
        String age = scan.nextLine();

        LocalDate dob = LocalDate.parse(age);
        LocalDate now = LocalDate.now();

        long days = ChronoUnit.DAYS.between(dob, now);

        System.out.println("Days you've been alive: " + days);

        scan.close();
    }
    
}
