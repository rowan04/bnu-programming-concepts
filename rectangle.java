import java.util.Scanner;

public class rectangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int height;
        int width;
        System.out.println("Enter the height:");
        height = scan.nextInt();
        System.out.println("Enter the width:");
        width = scan.nextInt();
        int perimeter = (2 * height) + (2 * width);
        System.out.println("The perimeter is: " + perimeter);
        int area = (height * width);
        System.out.println("The area is: " + area);
    }
}
