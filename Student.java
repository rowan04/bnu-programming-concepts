import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class assign {
    public static void main(String[] args) {
        // creating course values
        String courseCode = "BB1DTS2";
        String courseName = "BSc (Hons) Digital and Technology Solutions";

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

        // course constructor
        Course course = new Course(courseCode, courseName);
        String course_code = course.getCode();
        String course_name = course.getName();

        // add modules to course
        course.AddModules(modules);

        // output course info
        printCourse(course_code, course_name, modules);

        // student constructors
        String student1Name = "Rowan";
        int student1Id = 22220407;
        Student student1 = new Student(student1Name, student1Id);

        String student2Name = "Beth";
        int student2Id = 22229613;
        Student student2 = new Student(student2Name, student2Id);

        String student3Name = "Max";
        int student3Id = 22225520;
        Student student3 = new Student(student3Name, student3Id);

        String student4Name = "Ella";
        int student4Id = 22223167;
        Student student4 = new Student(student4Name, student4Id);

        // add students to ArrayList
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        // print student and marks for each module
        printStudent(students, course, course_name, modules);

        // print out the statistics
        printMinMark();
        printMaxMark();
        printMeanMark();
    }

    //print course details and it's modules
    public static void printCourse(String code, String name, ArrayList<Module> modules) {
        // output course details
        System.out.println("Course name is: " + name);
        System.out.println("Course code is: " + code);
        System.out.println("Course modules are:");
        // output modules
        int count = 0;
        for(Module moduleX : modules) {
            String module_name = moduleX.getModuleName();
            String module_code = moduleX.getModuleCode();
            System.out.println(module_name + ", with code: " + module_code);
            count = count + 1;
        }
        // output new line to seperate outputs
        System.out.println("");
    }

    //print student details and their mark/grade for each of their modules
    public static void printStudent(ArrayList<Student> students, Course course, String course_name, ArrayList<Module> modules) {
        // set i as a count
        int i = 0;
        for(Student studentX : students) {
            // get student info
            String name = studentX.getName();
            int id = studentX.getId();

            //enroll student on course
            studentX.Enroll(course);

            // generate marks for each module
            int mark1 = ModuleMark.getMark1();
            int mark2 = ModuleMark.getMark2();
            int mark3 = ModuleMark.getMark3();
            int mark4 = ModuleMark.getMark4();

            // set marks and get array
            Student.setMarks(mark1, mark2, mark3, mark4);
            int[] marks = Student.getMarks();

            // outputting student details
            System.out.println("Student name is: " + name);
            System.out.println("Student id is: " + id);
            System.out.println("They are enrolled on: " + course_name);

            // outputting mark and grade for each module
            System.out.println("Student's mark for each course module:");
            int count = 0;
            for(Module moduleX : modules) {
                // get module name
                String module_name = moduleX.getModuleName();

                // get students mark for the module from the marks array
                int mark = marks[count];
                // add students mark to the marksCalc array
                ModuleMark.addMarksCalc(i, mark);
                // add students name to the name array to correspond mark to student
                ModuleMark.addMarksStudent(i, name);

                // calculate the grade using getGrade method
                Module.grade grade = moduleX.getGrade(mark);

                // output
                System.out.println("Marks for module " + module_name + " is: " + mark + ", so grade for module is: Grade " + grade + ".");

                // adding to counts
                count = count + 1;
                i = i + 1;
            }
            // outputting new line to split up output
            System.out.println("");
        }
    }

    public static void printMinMark() {
        // finding the minimum mark
        int minMark = ModuleMark.getMinMark();
        // finding the student that corresponds to that mark
        String minMarkStudent = ModuleMark.getMinMarkStudent(minMark);
        // output
        System.out.println("The worst mark achieved was: " + minMark + " by: " + minMarkStudent);
    }

    public static void printMaxMark() {
        // finding the maximum mark
        int maxMark = ModuleMark.getMaxMark();
        // finding the student that corresponds to that mark
        String maxMarkStudent = ModuleMark.getMaxMarkStudent(maxMark);
        // output
        System.out.println("The best mark achieved was: " + maxMark + " by: " + maxMarkStudent);
    }

    public static void printMeanMark() {
        //finding the mean mark
        double meanMark = ModuleMark.getMeanMark();
        System.out.println("The mean mark achieved was: " + meanMark);
    }
}

public class Student {
    public String name;
    public int id;
    public Course course;
    public static int[] marks = new int[4];
    public ArrayList<Student> students;
    
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static void setMarks(int mark1, int mark2, int mark3, int mark4) {
        Student.marks[0] = mark1;
        Student.marks[1] = mark2;
        Student.marks[2] = mark3;
        Student.marks[3] = mark4;
    }

    public void AddStudents(ArrayList<Student> students) {
        this.students = students;
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

class ModuleMark {
    public static int mark1;
    public static int mark2;
    public static int mark3;
    public static int mark4;
    static Random randomNum = new Random();
    public static int[] marksCalc = new int[16];
    public static String[] marksStudent = new String[16];

    public static int getMark1() {
        mark1 = randomNum.nextInt(101);
        return mark1;
    }

    public static int getMark2() {
        mark2 = randomNum.nextInt(101);
        return mark2;
    }

    public static int getMark3() {
        mark3 = randomNum.nextInt(101);
        return mark3;
    }

    public static int getMark4() {
        mark4 = randomNum.nextInt(101);
        return mark4;
    }

    public static void addMarksCalc(int i, int mark) {
        ModuleMark.marksCalc[i] = mark;
    }

    public static void addMarksStudent(int i, String studentName) {
        ModuleMark.marksStudent[i] = studentName;
    }

    public static int getMinMark() {
        int minMark = Arrays.stream(marksCalc).min().getAsInt();
        return(minMark);
    }

    public static String getMinMarkStudent(int minMark) {
        int index = 0;
        for (int i : marksCalc) {
            if (i == minMark) {
                String minMarkStudent = marksStudent[index];
                return (minMarkStudent);
            }
            else {
                index = index + 1;
            }
        }
        return null;
    }

    public static int getMaxMark() {
        int maxMark = Arrays.stream(marksCalc).max().getAsInt();
        return(maxMark);
    }

    public static String getMaxMarkStudent(int maxMark) {
        int index = 0;
        for (int i : marksCalc) {
            if (i == maxMark) {
                String maxMarkStudent = marksStudent[index];
                return (maxMarkStudent);
            }
            else {
                index = index + 1;
            }
        }
        return null;
    }

    public static double getMeanMark() {
        int sum = 0;
        for (int i = 0; i < 16; i++) {
            sum += marksCalc[i];
        }
        double meanMark = sum/16;
        return(meanMark);
    }
}