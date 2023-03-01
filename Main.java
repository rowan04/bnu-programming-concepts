import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String yourName;
        System.out.println("Enter your name:");
        yourName = scan.nextLine();
        System.out.println("Hello " + yourName);
        scan.close();
    }
}