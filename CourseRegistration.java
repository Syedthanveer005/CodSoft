import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + "\nTitle: " + title + "\nDescription: " + description +
               "\nCapacity: " + capacity + "\nSchedule: " + schedule + "\n";
    }
}

class Student {
    private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        System.out.println("Course registration successful: " + course.getCourseCode());
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            System.out.println("Course dropped successfully: " + course.getCourseCode());
        } else {
            System.out.println("Course not found in your registered courses.");
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name + "\n";
    }
}

class CourseRegistrationSystem {
    private List<Course> courses;
    private List<Student> students;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayAvailableCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public Student getStudentByID(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public Course getCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
class CourseRegistrationApp {
    public static void main(String[] args) {
        CourseRegistrationSystem registrationSystem = new CourseRegistrationSystem();
        Scanner scanner = new Scanner(System.in);

        // Adding sample courses
        Course c1 = new Course("CSC101", "Introduction to Computer Science", "Fundamentals of programming", 50, "Mon/Wed 10:00 AM");
        Course c2 = new Course("MAT202", "Linear Algebra", "Basic linear algebra concepts", 40, "Tue/Thu 2:00 PM");
        Course c3 = new Course("ENG301", "Advanced English Composition", "Advanced writing skills", 30, "Mon/Fri 1:00 PM");

        registrationSystem.addCourse(c1);
        registrationSystem.addCourse(c2);
        registrationSystem.addCourse(c3);

        while (true) {
            System.out.println("\n1. Student Registration");
            System.out.println("2. Course Listing");
            System.out.println("3. Exit");

            System.out.print("Choose an option (1-3): ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentID = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();

                    Student student = new Student(studentID, studentName);
                    registrationSystem.addStudent(student);

                    studentMenu(student, registrationSystem, scanner);
                    break;
                case 2:
                    registrationSystem.displayAvailableCourses();
                    break;
                case 3:
                    System.out.println("Exiting. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private static void studentMenu(Student student, CourseRegistrationSystem registrationSystem, Scanner scanner) {
        while (true) {
            System.out.println("\nStudent Menu");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Registered Course");
            System.out.println("4. Logout");

            System.out.print("Choose an option (1-4): ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    registrationSystem.displayAvailableCourses();
                    break;
                case 2:
                    System.out.print("Enter course code to register: ");
                    String registerCourseCode = scanner.nextLine();
                    Course registerCourse = registrationSystem.getCourseByCode(registerCourseCode);
                    if (registerCourse != null) {
                        student.registerCourse(registerCourse);
                    } else {
                        System.out.println("Invalid course code.");
                    }
                    break;
                case 3:
                    System.out.print("Enter course code to drop: ");
                    String dropCourseCode = scanner.nextLine();
                    Course dropCourse = registrationSystem.getCourseByCode(dropCourseCode);
                    if (dropCourse != null) {
                        student.dropCourse(dropCourse);
                    } else {
                        System.out.println("Invalid course code.");
                    }
                    break;
                case 4:
                    System.out.println("Logging out. Thank you!");
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
