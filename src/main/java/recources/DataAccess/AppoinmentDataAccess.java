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
import resources.Model.Appoinment;
/**
 *
 * @author induwara
 */
public class AppoinmentDataAccess {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/abc_lab";
    static final String USER = "root";
    static final String PASS = "";
    
     public AppoinmentDataAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            }
        }
     
 public Appoinment getAppoinment(int id) throws SQLException {
        Appoinment st = null;
         try {

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Appoinment WHERE apId="+ id);) {
                while (rs.next()) {
                    st = new Appoinment();
                    st.setApId(rs.getInt("apId"));
                    st.setApDetails(rs.getString("apDetails"));
                    st.setApDocuments(rs.getString("apDocuments"));
                    st.setpId(rs.getInt("pId"));
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
 
     public List<Appoinment> getAppoinment() {
        List<Appoinment> Appoinments = new ArrayList<>();
         try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Appoinment");) {
                while (rs.next()) {
                    Appoinment st = new Appoinment();
                    //st = new Appoinment();
                    st = new Appoinment();
                    st.setApId(rs.getInt("apId"));
                    st.setApDetails(rs.getString("apDetails"));
                    st.setApDocuments(rs.getString("apDocuments"));
                    st.setpId(rs.getInt("pId"));
                    Appoinments.add(st);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

        return Appoinments;
    }
     
      public boolean addAppoinment(Appoinment st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("INSERT INTO Appoinment (apDetails, apDocuments, pId) "
                        + "VALUES ('"+ st.getApDetails()+"','"+ st.getApDocuments()+"','"+ st.getpId()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
     
       public boolean deleteAppoinment(int id) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("DELETE FROM Appoinment WHERE (apId = '"+ id + "');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }   
}

