import java.util.Scanner;

public class Student {
    public String name;
    public int id;
    
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
}

class assign {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student name:");
        String studentName = scan.nextLine();
        System.out.println("Enter student id:");
        int studentId = scan.nextInt();
        scan.close();

        Student student = new Student(studentName, studentId);
    }
}