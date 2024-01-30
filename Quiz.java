import java.util.*;

public class Quiz {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\t\t\t\tWelcome to Quiz Game");
        String[] questions = {"Number of primitive data types in Java are?", "What is the size of float and double in Java?",
                "Automatic type conversion is possible in which of the possible cases?", "Select the valid statement",
                "Select the valid statement to declare and initialize an array"};
        String[][] options = {{"6", "7", "8", "9"}, {"32 & 32", "32 & 64", "64 & 32", "64 & 64"},
                {"Byte to Int", "Int to Long", "Short to Int", "Long to Int"},
                {"char[]ch=new char(5)", "char[]ch=new char[5]", "char[]ch=new char[]", "char[]ch=new char()"},
                {"int[]A={1,2,3}", "int[]A={}", "int[]A={(1,2,3)}", "int[]A=()"}};
        char[] ans = {'C', 'B', 'B', 'B', 'A'};
        int correct = 0;
        int total = questions.length;
        long startTime = System.currentTimeMillis();
        long timeLimit = 60 * 1000;

        for (int i = 0; i < questions.length; i++) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            long remainingTime = timeLimit - elapsedTime;

            System.out.println("\nTime remaining: " + (remainingTime / 1000) + " seconds");

            if (remainingTime <= 0) {
                System.out.println("Time's up! Quiz completed.");
                break;
            }

            System.out.println(questions[i]);
            System.out.println("A)" + options[i][0]);
            System.out.println("B)" + options[i][1]);
            System.out.println("C)" + options[i][2]);
            System.out.println("D)" + options[i][3]);
            char choice = sc.nextLine().toUpperCase().charAt(0);

            if (choice == ans[i]) {
                correct++;
                System.out.println("Correct Answer");
            } else {
                System.out.println("Wrong Answer");
            }
        }

        int score = correct * 20;
        int wrong = total - correct;
        System.out.println("\nScore: " + score + "\tCorrect: " + correct + "\tWrong: " + wrong);
    }
}
