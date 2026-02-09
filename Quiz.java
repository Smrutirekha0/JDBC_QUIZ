import java.sql.*;
import java.util.Scanner;

public class Quiz {

    public static int startQuiz() {
        int marks = 0;

        try {
            Connection con = DBConnection.getConnection();
            CallableStatement cs =
                    con.prepareCall("{call get_questions()}");

            ResultSet rs = cs.executeQuery();
            Scanner sc = new Scanner(System.in);

            while (rs.next()) {
                System.out.println("\n" + rs.getString("question"));
                System.out.println("1. " + rs.getString("option1"));
                System.out.println("2. " + rs.getString("option2"));
                System.out.println("3. " + rs.getString("option3"));
                System.out.println("4. " + rs.getString("option4"));

                System.out.print("Enter option: ");
                int ans = sc.nextInt();

                if (ans == rs.getInt("correct_option")) {
                    marks++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return marks;
    }
}

