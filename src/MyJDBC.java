import java.sql.*;
import java.util.Scanner;

public class MyJDBC {

    //NOTE: Inserts a new user into the database
    public static void insertUser(Statement stmt, String name, String studentID) {
        try {
            String query = "INSERT INTO users (name, studentID) VALUES ('" + name + "', '" + studentID + "')";
            stmt.executeUpdate(query);
            System.out.println("User inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting user: " + name);
            e.printStackTrace();
        }
    }

    //NOTE: Shows the last inserted user
    public static void showLastUser(Statement stmt) {
        try {
            String query = "SELECT * FROM users ORDER BY waitingNumber DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                System.out.println("---- Name & Waiting Number ----");
                System.out.println("Wait Number: " + rs.getInt("waitingNumber"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("StudentID   : " + rs.getString("studentID"));
                System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching last user.");
            e.printStackTrace();
        }
    }

    //NOTE: Clears the users table
    public static void clearTable(Statement stmt) {
        try {
            stmt.executeUpdate("TRUNCATE TABLE users");
            System.out.println("Table cleared at program start.");
        } catch (SQLException e) {
            System.out.println("Error clearing table.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login_schema", "root", "Josean555@");
                Statement stmt = conn.createStatement();
                Scanner sc = new Scanner(System.in)
        ) {
            clearTable(stmt);

            int repeat;
            do {
                System.out.print("Name    : ");
                String name = sc.nextLine();

                System.out.print("StudentID: ");
                String studentID = sc.nextLine();

                insertUser(stmt, name, studentID);
                showLastUser(stmt);

                System.out.print("Add another name? (1 = yes, 0 = no): ");
                repeat = sc.nextInt();
                sc.nextLine(); // clear newline
            } while (repeat == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
