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
        // instantiating object of student class
        Student student1 = new Student("Rowan" ,22220407);
        String name1 = student1.getName();
        int id1 = student1.getId();
        printStudent(name1, id1);
        
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
        System.out.println("Student id is: " + id);
    }
}

class Course {
    public String code;
    public String name;
    
    public Course(String code, String name) {
        this.code = code;
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }
}