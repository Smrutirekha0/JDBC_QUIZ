import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (Login.validate(roll, pass)) {
            System.out.println("\nLogin Successful!");
            int marks = Quiz.startQuiz();
            Result.saveResult(roll, marks);
        } else {
            System.out.println("Invalid Login!");
        }
    }
}
