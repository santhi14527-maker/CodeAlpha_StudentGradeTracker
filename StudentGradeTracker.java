import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    double getAverage() {
        int sum = 0;
        for (int g : grades) sum += g;
        return grades.size() == 0 ? 0 : (double) sum / grades.size();
    }

    int getHighest() {
        int max = Integer.MIN_VALUE;
        for (int g : grades) max = Math.max(max, g);
        return max;
    }

    int getLowest() {
        int min = Integer.MAX_VALUE;
        for (int g : grades) min = Math.min(min, g);
        return min;
    }
}
public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Grades");
            System.out.println("3. Show Report");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    students.add(new Student(sc.next()));
                    System.out.println("Student added.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students available!");
                        break;
                    }
                    
                    System.out.println("Choose student: ");
                    for (int i = 0; i < students.size(); i++)
                        System.out.println((i + 1) + ". " + students.get(i).name);
                    int idx = sc.nextInt() - 1;

                    System.out.print("Enter grade: ");
                    int grade = sc.nextInt();
                    students.get(idx).grades.add(grade);
                    System.out.println("Grade added.");
                    break;

                case 3:
                    System.out.println("\n--- Student Report ---");
                    for (Student s : students) {
                        System.out.println("\nName: " + s.name);
                        System.out.println("Grades: " + s.grades);
                        System.out.println("Avg: " + s.getAverage());
                        System.out.println("Highest: " + s.getHighest());
                        System.out.println("Lowest: " + s.getLowest());
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    
}
