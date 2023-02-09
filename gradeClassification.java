import java.util.Scanner;

public class gradeClassification {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char grade;
        System.out.println("Please enter your grade:");
        grade = scan.next().charAt(0);
        switch(grade) {
            case 'A': System.out.println("University undergraduate clasification: 1st.");break;
            case 'B': System.out.println("University undergraduate clasification: 2:1.");break;
            case 'C': System.out.println("University undergraduate clasification: 2:2.");break;
            case 'D': System.out.println("University undergraduate clasification: 3rd.");break;
            case 'E': System.out.println("University undergraduate clasification: Ordinary.");break;
            case 'F': System.out.println("University undergraduate clasification: Fail.");break;
            default: System.out.println("Invalid mark.");
        }
    }
}
