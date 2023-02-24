//import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

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

        // add marks for each module
        Random randomNum = new Random();
        int mark1 = randomNum.nextInt(101);
        int mark2 = randomNum.nextInt(101);
        int mark3 = randomNum.nextInt(101);
        int mark4 = randomNum.nextInt(101);

        // student constructor
        Student student = new Student(studentName, studentId, mark1, mark2, mark3, mark4);
        String name = student.getName();
        int id = student.getId();

        // course constructor
        Course course = new Course(courseCode, courseName);
        String course_code = course.getCode();
        String course_name = course.getName();
        
        // enroll student on course
        student.Enroll(course);

        //add modules to course
        course.AddModules(modules);

        // print methods
        printStudent(name, id, course_name);
        printCourse(course_code, course_name);

        // get marks array
        int[] marks = Student.getMarks();

        // printing course modules
        System.out.println("Course modules are:");
        int count = 0;
        for(Module module : modules) {
            String module_name = module.getModuleName();
            String module_code = module.getModuleCode();
            System.out.println("Module: " + module_name + ", with code: " + module_code);
            // outputting mark and grade for each module
            int mark = marks[count];
            Module.grade grade = module.getGrade(mark);
            System.out.println("Marks for module is: " + mark + ", so grade for module is: Grade " + grade + ".");
            count = count + 1;
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
    public static int[] marks = new int[4];
    
    public Student(String name, int id, int mark1, int mark2, int mark3, int mark4) {
        this.name = name;
        this.id = id;
        Student.marks[0] = mark1;
        Student.marks[1] = mark2;
        Student.marks[2] = mark3;
        Student.marks[3] = mark4;
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }

    public static int[] getMarks() {
        return marks;
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

    enum grade {
        F,
        E,
        D,
        C,
        B,
        A,
        INVALID
    }

    public grade getGrade(int mark) {
        if (mark >= 0 && mark <= 29) {
            return grade.F;
        } else if (mark >= 30 && mark <= 39) {
            return grade.E;
        } else if (mark >= 40 && mark <= 49) {
            return grade.D;
        } else if (mark >= 50 && mark <= 59) {
            return grade.C;
        } else if (mark >= 60 && mark <= 69) {
            return grade.B;
        } else if (mark >=70 && mark <= 100) {
            return grade.A;
        } else {
            return grade.INVALID;
        }
    }
}