import java.util.Scanner;
public class StudentGradesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); 
        String[] subjects = new String[numSubjects];
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter the name of subject " + (i + 1) + ": ");
            subjects[i] = scanner.nextLine();
            int mark = -1;
            while (mark < 0 || mark > 100) {
                System.out.print("Enter marks for " + subjects[i] + " (out of 100): ");
                if (scanner.hasNextInt()) {
                    mark = scanner.nextInt();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid input! Marks should be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next(); 
                }
            }
            marks[i] = mark;
            totalMarks += mark;
            scanner.nextLine(); 
        }
        double averagePercentage = totalMarks / (double) numSubjects;
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("\n=== Results ===");
        System.out.println("Subject\t\tMarks");
        System.out.println("-------------------------");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println(subjects[i] + "\t\t" + marks[i]);
        }
        System.out.println("-------------------------");
        System.out.println("Total Marks:    " +     totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}
