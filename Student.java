//import java.util.Scanner;
import java.util.ArrayList;

class assign {
    public static void main(String[] args) {
        // instantiating object of student class using set values
        String studentName = "Rowan";
        int studentId = 22220407;
        String courseCode = "BB1DTS2";
        String courseName = "BSc (Hons) Digital and Technology Solutions";
        
        /* get values from user to instantiate object
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student name:");
        String studentName = scan.nextLine();
        System.out.println("Enter student id:");
        int studentId = scan.nextInt();
        System.out.println("Enter course code:");
        String courseCode = scan.next();
        System.out.println("Enter course name:");
        String courseName = scan.next();
        System.out.println("\n");
        scan.close();
        */

        // student constructor
        Student student = new Student(studentName, studentId);
        String name = student.getName();
        int id = student.getId();

        // course constructor
        Course course = new Course(courseCode, courseName);
        String course_code = course.getCode();
        String course_name = course.getName();

        // module constructors
        String module1Name = "Programming Concepts";
        String module1Code = "CO452";
        Module module1 = new Module(module1Name, module1Code);

        String module2Name = "Computer Architectures";
        String module2Code = "CO450";
        Module module2 = new Module(module2Name, module2Code);

        String module3Name = "Web Development";
        String module3Code = "CO456";
        Module module3 = new Module(module3Name, module3Code);

        String module4Name = "Networking";
        String module4Code = "CO451";
        Module module4 = new Module(module4Name, module4Code);

        // add modules to ArrayList
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(module1);
        modules.add(module2);
        modules.add(module3);
        modules.add(module4);
        
        // enroll student on course
        student.Enroll(course);

        //add modules to course
        course.AddModules(modules);

        // print methods
        printStudent(name, id, course_name);
        printCourse(course_code, course_name);

        // printing course modules
        System.out.println("Course modules are:");
        for(Module module : modules) {
            String module_name = module.getModuleName();
            String module_code = module.getModuleCode();
            System.out.println("Module: " + module_name + ", with code: " + module_code);
        }
    }

    //print student details
    public static void printStudent(String name, int id, String course_name) {
        System.out.println("Student name is: " + name);
        System.out.println("Student id is: " + id);
        System.out.println("They are enrolled on: " + course_name + "\n");
    }

    //print course details
    public static void printCourse(String code, String name) {
        System.out.println("Course code is: " + code);
        System.out.println("Course name is: " + name + "\n");
    }
}

public class Student {
    public String name;
    public int id;
    public Course course;
    public int[] marks = new int[4];
    
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

    public void Enroll(Course course) {
        this.course = course;
    }
}

class Course {
    public String code;
    public String name;
    public ArrayList<Module> modules;
    
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

    public void AddModules(ArrayList<Module> modules) {
        this.modules = modules;
    }
}

class Module {
    public String moduleName;
    public String moduleCode;

    public Module(String moduleName, String moduleCode) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }
}