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
import resources.Model.Technicians;

/**
 *
 * @author induwara
 */
public class TechniciansDataAccess {
    
    static final String DB_URL = "jdbc:mysql://localhost:3306/abc_lab";
    static final String USER = "root";
    static final String PASS = "";
    
    
        public TechniciansDataAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            
        }
    }
    
    public Technicians getTechnician(int id) throws SQLException {
        Technicians st = null;
         try {

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Technician WHERE tId="+ id);) {
                while (rs.next()) {
                    st = new Technicians();
                    st.settId(rs.getInt("tId"));
                    st.settName(rs.getString("tName"));
                    st.setNic(rs.getString("nic"));
                    st.setPhoneNumber(rs.getString("phoneNumber"));
                    st.setEmail(rs.getString("email"));
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
    
    public List<Technicians> getTechnicians() {
        List<Technicians> Technicians = new ArrayList<>();
         try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Technician");) {
                while (rs.next()) {
                    Technicians st = new Technicians();
                   //st = new Technicians();
                    st.settId(rs.getInt("tId"));
                    st.settName(rs.getString("tName"));
                    st.setNic(rs.getString("nic"));
                    st.setPhoneNumber(rs.getString("phoneNumber"));
                    st.setEmail(rs.getString("email"));
                    st.setUiId(rs.getInt("uiId"));
                    Technicians.add(st);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

        return Technicians;
    }
    
    public boolean addTechnician(Technicians st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("INSERT INTO Technician (tName, nic, phoneNumber, email, uiId) "
                        + "VALUES ('"+ st.gettName()+"','"+ st.getNic()+"','"+ st.getPhoneNumber()+"', '"+ st.getEmail()+"', '"+ st.getUiId()+"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
   
    public boolean updateTechnician(Technicians st) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("UPDATE Technician SET tName = '" +st.gettName()+ "', nic = '" + st.getNic()+ "', phoneNumber = '" + st.getPhoneNumber()+ "', email = '" + st.getEmail()+ "', uiId = '" + st.getUiId()+ "' WHERE (tId = '" + st.gettId() +"');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
    
    public boolean deleteTechnician(int id) {
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); 
                    Statement stmt = conn.createStatement(); 
                    ) {
                stmt.executeUpdate("DELETE FROM Technician WHERE (tid = '"+ id + "');");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
        return false;
    }
}
