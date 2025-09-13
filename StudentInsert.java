import java.sql.*;
import java.util.Scanner;

public class StudentInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/a";
        String user = "root";
        String password = "ShenuriPerera2002.";
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Student Marks: ");
        String marks = sc.next();

        try {
            // Connect to DB
            Connection conn = DriverManager.getConnection(url, user, password);


            String sql = "INSERT INTO studentsperformance (name, age, marks) VALUES ( ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);


            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, marks);

            // Execute insert
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student added successfully!");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
