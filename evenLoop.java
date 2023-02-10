import java.util.Scanner;

public class evenLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int startNum;
        int count = 0;
        System.out.println("Please enter the starting number:");
        startNum = scan.nextInt();
        int num = startNum + 1;
        System.out.println("The next 5 even numbers after your inputted number:");
        while (count < 10) {
            if (num % 2 == 0) {
                System.out.println(num);
                num = num + 1;
                count = count + 1;
            } else {
                num = num + 1;
                count = count + 1;
            }
        }
    }
}
