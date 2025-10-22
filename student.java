import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    String rollNumber;
    String name;
    int age;

    Student(String rollNumber, String name, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", Age: " + age;
    }
}

// Main class
public class StudentManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("Exiting... Bye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);
    }

    static void addStudent() {
        System.out.print("Enter roll number: ");
        String roll = sc.next();
        sc.nextLine(); // consume newline
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        Student s = new Student(roll, name, age);
        studentList.add(s);
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    static void deleteStudent() {
        System.out.print("Enter roll number of student to delete: ");
        String roll = sc.next();
        boolean removed = studentList.removeIf(s -> s.rollNumber == roll);
        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}