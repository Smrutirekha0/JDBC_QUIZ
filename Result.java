import java.sql.*;

public class Result {

    public static void saveResult(int roll, int marks) {
        String status = (marks >= 3) ? "PASS" : "FAIL";

        try {
            Connection con = DBConnection.getConnection();
            CallableStatement cs =
                    con.prepareCall("{call insert_result(?,?,?)}");

            cs.setInt(1, roll);
            cs.setInt(2, marks);
            cs.setString(3, status);

            cs.execute();

            System.out.println("\n===== RESULT =====");
            System.out.println("Roll No : " + roll);
            System.out.println("Marks   : " + marks);
            System.out.println("Status  : " + status);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

