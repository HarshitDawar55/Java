//General JDBC Code to connect to MySQL Database

package JDBC;

import java.sql.*;

public class JDBCMYSQL {
    // Driver name
    static final String Driver = "com.mysql.jdbc.Driver";

    // Query
    static final String query = "select * from employee";

    // Database Path
    static final String db_path = "jdbc:mysql://localhost/database_name";

    // Mysql Credentials
    static final String username = "username";
    static final String password = "password";

    public static void main(String[] args) {
        Connection con = null;  // Creating connection variable
        Statement st = null;   // Creating Statement Variable
        try {
            Class.forName(Driver);   // Registering the Driver
            con = DriverManager.getConnection(db_path,username,password);  // Creating/Establishing a Connection with the Database
            st = con.createStatement();             // Creating a Statement
            ResultSet rs = st.executeQuery(query);  // Executing that Statement

            while (rs.next()) {
                // Retreiving data based on the column names and printing it!
                System.out.println("First_Name: " + rs.getString("First_name") + "\tLast_Name: " + rs.getString("Last_name") + "\tEmployee_Id: " + rs.getInt("Employee_id") + "\tDate_Of_Birth: " + rs.getString("DOB") + "\tSalary: " + rs.getDouble("Salary") + "\tDepartment_id: " + rs.getInt("Department_Id"));
            }

            rs.close();
            st.close();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(con!=null){
                    con.close();
                }
            }
            catch (SQLException se){
                se.printStackTrace();
            }
            try {
                if(st!=null){
                    st.close();
                }
            }catch (SQLException s){
                s.printStackTrace();
            }
        }
    }

}
