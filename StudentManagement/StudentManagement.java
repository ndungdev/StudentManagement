import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private ArrayList<Student> studentList;
    private Scanner scanner;

    // Constructor
    public StudentManagement() {
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Display menu
    public void displayMenu() {
        System.out.println("\n--- Student Management System ---");
        System.out.println("1. Add Students");
        System.out.println("2. Search Students by Last Name");
        System.out.println("3. Search and Edit Student by Full Name");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    // Add students
    public void addStudents() {
        System.out.print("Enter the number of students to add: ");
        int numStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();

            studentList.add(new Student(firstName, lastName));
        }

        System.out.println("Students added successfully!");
    }

    // Search students by last name
    public void searchByLastName() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();

        ArrayList<Student> results = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                results.add(student);
            }
        }

        if (results.isEmpty()) {
            System.out.println("No students found with last name: " + lastName);
        } else {
            System.out.println("Search Results:");
            for (Student student : results) {
                System.out.println(student);
            }
        }
    }

    // Search and edit student by full name
    public void searchAndEditByFullName() {
        System.out.print("Enter full name to search (FirstName LastName): ");
        String fullName = scanner.nextLine();

        Student foundStudent = null;
        for (Student student : studentList) {
            if ((student.getFirstName() + " " + student.getLastName()).equalsIgnoreCase(fullName)) {
                foundStudent = student;
                break;
            }
        }

        if (foundStudent != null) {
            System.out.println("Student found: " + foundStudent);
            System.out.print("Enter new first name: ");
            String newFirstName = scanner.nextLine();
            System.out.print("Enter new last name: ");
            String newLastName = scanner.nextLine();

            foundStudent.setFirstName(newFirstName);
            foundStudent.setLastName(newLastName);
            System.out.println("Student information updated successfully!");
        } else {
            System.out.println("No student found with name: " + fullName);
        }
    }

    // Main loop
    public void start() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    searchByLastName();
                    break;
                case 3:
                    searchAndEditByFullName();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        sm.start();
    }
}
