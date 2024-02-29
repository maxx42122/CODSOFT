import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private char grade;

    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public char getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade=" + grade +
                '}';
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        System.out.println("Student removed successfully!");
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("All Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}

 class SystemApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent(scanner, system);
                    break;
                case 2:
                    removeStudent(scanner, system);
                    break;
                case 3:
                    searchStudent(scanner, system);
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentManagementSystem system) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter student grade: ");
        char grade = scanner.next().charAt(0);

        Student student = new Student(name, rollNumber, grade);
        system.addStudent(student);
    }

    private static void removeStudent(Scanner scanner, StudentManagementSystem system) {
        System.out.print("Enter roll number of the student to remove: ");
        int rollNumber = scanner.nextInt();
        system.removeStudent(rollNumber);
    }

    private static void searchStudent(Scanner scanner, StudentManagementSystem system) {
        System.out.print("Enter roll number of the student to search: ");
        int rollNumber = scanner.nextInt();
        Student student = system.searchStudent(rollNumber);

        if (student != null) {
            System.out.println("Student found:\n" + student);
        } else {
            System.out.println("Student not found.");
        }
    }
}

