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
import resources.Model.Patients;
/**
 *
 * @author induwara
 */
public class PatientsDataAccess {
    
       static final String DB_URL = "jdbc:mysql://localhost:3306/abc_lab";
    static final String USER = "root";
    static final String PASS = "";
    
     public PatientsDataAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            }
        }
     
      public Patients getPatients(int id) throws SQLException {
        Patients st = null;
         try {

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Patients WHERE pId="+ id);) {
                while (rs.next()) {
                    st = new Patients();
                    st.setpId(rs.getInt("pId"));
                    st.setpName(rs.getString("pName"));
                    st.setNic(rs.getString("nic"));
                    st.setPhoneNumber(rs.getString("phoneNumber"));
                    st.setEmail(rs.getString("email"));
                    st.setDob(rs.getDate("dob"));
                    st.setUiId(rs.getInt("uiId"));
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
    
      
      public List<Patients> getPatients() {
        List<Patients> Patients = new ArrayList<>();
         try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Patients");) {
                while (rs.next()) {
                    Patients st = new Patients();
                   //st = new Technicians();
                    st.setpId(rs.getInt("pId"));
                    st.setpName(rs.getString("pName"));
                    st.setNic(rs.getString("Nic"));
                    st.setPhoneNumber(rs.getString("phoneNumber"));
                    st.setEmail(rs.getString("email"));
                    st.setDob(rs.getDate("dob"));
                    st.setUiId(rs.getInt("uiId"));
                    Patients.add(st);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

        return Patients;
    }
      
       public boolean addPatients(Patients st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("INSERT INTO Patients (pName, nic, phoneNumber, email, dob , uiId) "
                        + "VALUES ('"+ st.getpName()+"','"+ st.getNic()+"','"+ st.getPhoneNumber()+"', '"+ st.getEmail()+"', '"+ st.getDob()+"', '"+ st.getUiId()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
       
       public boolean updatePatients(Patients st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("UPDATE Patients SET pName = '" +st.getpName()+ "', nic = '" + st.getNic()+ "', phoneNumber = '" + st.getPhoneNumber()+ "', email = '" + st.getEmail()+ "',dob = '" + st.getDob()+ "', uiId = '" + st.getUiId()+ "' WHERE (pId = '" + st.getpId() +"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
       
       public boolean deletePatients(int id) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("DELETE FROM Patients WHERE (pid = '"+ id + "');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
}