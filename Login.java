import java.sql.*;

public class Login {

    public static boolean validate(int roll, String pass) {
        try {
            Connection con = DBConnection.getConnection();
            CallableStatement cs =
                    con.prepareCall("{call student_login(?,?)}");

            cs.setInt(1, roll);
            cs.setString(2, pass);

            ResultSet rs = cs.executeQuery();

            return rs.next();   // true if student exists

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

