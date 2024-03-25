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
import static resources.EmailSend.Email.sendEmail;
import static resources.EmailSend.EmailFormat.emailBodyPayment;
import resources.Model.Appoinment;
import resources.Model.Patient;
import resources.Model.UserInformation;

/**
 *
 * @author induwara
 */
public class AppoinmentDataAccess {
    
     public AppoinmentDataAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            }
        }
     
 public Appoinment getAppoinment(int id) throws SQLException {
        Appoinment st = null;
         try {
            DBConfig db =  DBConfig.getConn();
            try (Connection conn = db.getConnection(); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Appoinment WHERE apId="+ id);) {
                while (rs.next()) {
                    st = new Appoinment();
                    st.setApId(rs.getInt("apId"));
                    st.setApDetails(rs.getString("apDetails"));
                    st.setApDocuments(rs.getString("apDocuments"));
                    st.setApType(rs.getString("apType"));
                    st.setRecdoc(rs.getString("redcoc"));
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
             DBConfig db =  DBConfig.getConn();
            try (Connection conn =  db.getConnection();  
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Appoinment");) {
                while (rs.next()) {
                    Appoinment st = new Appoinment();
                    //st = new Appoinment();
                    st = new Appoinment();
                    st.setApId(rs.getInt("apId"));
                    st.setApDetails(rs.getString("apDetails"));
                    st.setApDocuments(rs.getString("apDocuments"));
                    st.setApType(rs.getString("apType"));
                    st.setRecdoc(rs.getString("recdoc"));
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
            String msg = "";
            DBConfig db =  DBConfig.getConn();
            try (Connection conn =  db.getConnection();  
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("INSERT INTO Appoinment (recdoc, apType, apDetails, apDocuments, pId) "
                        + "VALUES ('"+ st.getApType()+"','"+ st.getRecdoc()+"','"+ st.getApDetails()+"','"+ st.getApDocuments()+"','"+ st.getpId()+"');");
                UserInformationDataAccess da = new UserInformationDataAccess();
                UserInformation pat = da.getUserInformation(st.getpId());
                sendEmail(pat.getEmail(),"Patient Appoinment Payment",emailBodyPayment(msg));
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
            DBConfig db =  DBConfig.getConn();
            try (Connection conn =  db.getConnection();  
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

