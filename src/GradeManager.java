public class GradeManager {

    public static String[] reverseStudentNames(String[] names) {
        String[] reversed = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            reversed[i] = new StringBuilder(names[i]).reverse().toString();
        }
        return reversed;
    }

    public static char getLetterGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        else return 'F';
    }

    public static String[] findFailingStudents(String[] names, int[] scores) {
        int count = 0;
        for (int score : scores) {
            if (score < 60) count++;
        }

        String[] failing = new String[count];
        int j = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failing[j] = names[i];
                j++;
            }
        }
        return failing;
    }

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        System.out.println("Reversed names:");
        String[] reversed = reverseStudentNames(students);
        for (String name : reversed) {
            System.out.println(name);
        }

        System.out.println("\nLetter Grades:");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + ": " + getLetterGrade(scores[i]));
        }

        System.out.println("\nStudents who failed:");
        String[] failed = findFailingStudents(students, scores);
        for (String name : failed) {
            System.out.println(name);
        }
    }
}
