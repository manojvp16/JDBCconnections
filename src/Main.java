import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        try {
            // ✅ Load database configuration from external file
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("config.properties");
            props.load(fis);

            String url = props.getProperty("db.url");
            String uname = props.getProperty("db.username");
            String pass = props.getProperty("db.password");

            // ✅ Establish connection
            Connection con = DriverManager.getConnection(url, uname, pass);
            System.out.println("✅ Connected to database successfully!");

            // -----------------------------------------------------------------
            // 🟩 CREATE (Insert a new record)
            // -----------------------------------------------------------------
            /*
            String insertQuery = "INSERT INTO student (sid, sname, smarks) VALUES (?, ?, ?)";
            PreparedStatement insertStmt = con.prepareStatement(insertQuery);
            insertStmt.setInt(1, 4);
            insertStmt.setString(2, "Meena");
            insertStmt.setInt(3, 90);
            int rowsInserted = insertStmt.executeUpdate();
            System.out.println(rowsInserted + " record(s) inserted successfully!");
            insertStmt.close();
            */

            // -----------------------------------------------------------------
            // 🟦 READ (Retrieve data)
            // ----------------------------------------------------------------

            String selectQuery = "SELECT * FROM student";
            Statement selectStmt = con.createStatement();
            ResultSet rs = selectStmt.executeQuery(selectQuery);

            System.out.println("\nStudent Records:");
            while (rs.next()) {
                int id = rs.getInt("sid");
                String name = rs.getString("sname");
                int marks = rs.getInt("smarks");
                System.out.println(id + " | " + name + " | " + marks);
            }

            rs.close();
            selectStmt.close();

            // -----------------------------------------------------------------
            // 🟨 UPDATE (Modify existing record)
            // -----------------------------------------------------------------
            /*
            String updateQuery = "UPDATE student SET smarks = ? WHERE sid = ?";
            PreparedStatement updateStmt = con.prepareStatement(updateQuery);
            updateStmt.setInt(1, 88); // new marks
            updateStmt.setInt(2, 2);  // student id
            int rowsUpdated = updateStmt.executeUpdate();
            System.out.println(rowsUpdated + " record(s) updated successfully!");
            updateStmt.close();
            */

            // -----------------------------------------------------------------
            // 🟥 DELETE (Remove record)
            // -----------------------------------------------------------------
            /*
            String deleteQuery = "DELETE FROM student WHERE sid = ?";
            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, 3);
            int rowsDeleted = deleteStmt.executeUpdate();
            System.out.println(rowsDeleted + " record(s) deleted successfully!");
            deleteStmt.close();
            */

            // ✅ Close connection
            con.close();
            System.out.println("✅ Connection closed.");

        } catch (IOException e) {
            System.out.println("⚠️ Error loading config file: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("⚠️ Database error: " + e.getMessage());
        }
    }
}
