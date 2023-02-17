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
        String name = student.getName();
        int id = student.getId();
        printStudent(name, id);
    }

    public static void printStudent(String name, int id) {
        System.out.println("Student name is: " + name);
        System.out.println("Student name is: " + id);
    }
}