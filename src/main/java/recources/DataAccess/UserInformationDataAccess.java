/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recources.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import resources.Model.UserInformation;
/**
 *
 * @author induwara
 */
public class UserInformationDataAccess {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/abc_lab";
    static final String USER = "root";
    static final String PASS = "";
    
    
        public UserInformationDataAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            
        }
    }
        
         public UserInformation getUserInformation(int id) throws SQLException {
        UserInformation st = null;
         try {

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM UserInformation WHERE tId="+ id);) {
                while (rs.next()) {
                    st = new UserInformation();
                    st.setuId(rs.getInt("uId"));
                    st.setUserName(rs.getString("userName"));
                    st.setPassword(rs.getString("password"));
                    st.setEmail(rs.getString("email"));
                    st.setrId(rs.getInt("rId"));
                    break;
                }
            } catch (SQLException e) {
                System.err.print(e);
                throw e;
            }

        } catch (SQLException e) {
            System.err.print(e);
            throw e;
        }

        return st;
    }
         
         public List<UserInformation> getUserInformation() {
        List<UserInformation> UserInformation = new ArrayList<>();
         try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM UserInformation");) {
                while (rs.next()) {
                    UserInformation st = new UserInformation();
                   //st = new Technicians();
                     st.setuId(rs.getInt("uId"));
                    st.setUserName(rs.getString("userName"));
                    st.setPassword(rs.getString("password"));
                    st.setEmail(rs.getString("email"));
                    st.setrId(rs.getInt("rId"));
                    UserInformation.add(st);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

        return UserInformation;
    }
         
         public boolean addUserInformation(UserInformation st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("INSERT INTO UserInformation (userName, password, email, rId) "
                        + "VALUES ('"+ st.getUserName()+"','"+ st.getPassword()+"','"+ st.getEmail()+"', '"+ st.getrId()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
         
         
         
             public boolean updateUserInformation(UserInformation st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("UPDATE UserInformation SET userName = '" +st.getUserName()+ "', password = '" + st.getPassword()+ "', email = '" + st.getEmail()+"', rId = '" + st.getrId()+ "' WHERE (uId = '" + st.getuId() +"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
             
             public boolean deleteUserInformation(int id) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("DELETE FROM UserInformation WHERE (uid = '"+ id + "');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
}
