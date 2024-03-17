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
import resources.Model.Prescription;
/**
 *
 * @author induwara
 */
public class PrescriptionDataAccess {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/abc_lab";
    static final String USER = "root";
    static final String PASS = "";
    
    
        public PrescriptionDataAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            
        }
    }
        
        public Prescription getPrescription(int id) throws SQLException {
        Prescription st = null;
         try {

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Prescription WHERE prId="+ id);) {
                while (rs.next()) {
                    st = new Prescription();
                    st.setPrId(rs.getInt("prId"));
                    st.setPrTestResult(rs.getString("PrTestResult"));
                    st.setPrComment(rs.getString("PrComment"));
                    st.setPrDocument(rs.getString("PrDocument"));
                    st.setApId(rs.getInt("apId"));
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
    
        
        public List<Prescription> getPrescription() {
        List<Prescription> Prescription = new ArrayList<>();
         try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Prescription");) {
                while (rs.next()) {
                    Prescription st = new Prescription();
                   //st = new Technicians();
                    st.setPrId(rs.getInt("prId"));
                    st.setPrTestResult(rs.getString("PrTestResult"));
                    st.setPrComment(rs.getString("PrComment"));
                    st.setPrDocument(rs.getString("PrDocument"));
                    st.setApId(rs.getInt("apId"));
                    Prescription.add(st);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

        return Prescription;
    }
        
        public boolean addPrescription(Prescription st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("INSERT INTO Prescription (PrTestResult, PrComment, PrDocument, apId) "
                        + "VALUES ('"+ st.getPrTestResult()+"','"+ st.getPrComment()+"','"+ st.getPrDocument()+"','"+ st.getApId()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
        
         public boolean updatePrescription(Prescription st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("UPDATE Prescription SET prTestResult = '" +st.getPrTestResult()+ "', PrComment = '" + st.getPrComment()+ "', PrDocument = '" + st.getPrDocument()+ "', ApId = '" + st.getApId()+ "' WHERE (prId = '" + st.getPrId()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
         
          public boolean deletePrescription(int id) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("DELETE FROM Prescription WHERE (prid = '"+ id + "');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
}
