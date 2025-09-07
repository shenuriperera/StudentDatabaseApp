import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/a";
        String user = "root";
        String password = "ShenuriPerera2002.";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // SQL with placeholders
            String sql = "INSERT INTO studentsperformance (name, age,marks) VALUES (?, ?, ?)";

            // Create PreparedStatement
            PreparedStatement pst = con.prepareStatement(sql);

            // Set values for the first record
            pst.setString(1, "alex");
            pst.setInt(2, 21);
            pst.setInt(3, 80);
            pst.executeUpdate();

            // Set values for another record
            pst.setString(1, "taylor");
            pst.setInt(2, 22);
            pst.setInt(3, 95);
            pst.executeUpdate();

            System.out.println("Records inserted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}