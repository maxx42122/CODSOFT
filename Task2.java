import java.util.Scanner;

class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        
        int[] subjectMarks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            subjectMarks[i] = scanner.nextInt();

            
            if (subjectMarks[i] < 0 || subjectMarks[i] > 100) {
                System.out.println("Invalid marks. Marks should be between 0 and 100.");
                return;
            }
        }

       
        int totalMarks = 0;
        for (int marks : subjectMarks) {
            totalMarks += marks;
        }

        
        double averagePercentage = (double) totalMarks / numSubjects;

        
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

        
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

