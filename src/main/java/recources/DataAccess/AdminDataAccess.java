/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recources.DataAccess;

/**
 *
 * @author induwara
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import resources.Model.Admin;

public class AdminDataAccess {
    
        public AdminDataAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            
        }
    }
     public Admin getAdmin(int id) throws SQLException {
        Admin st = null;
         try {
            DBConfig db =  DBConfig.getConn();
            try (Connection conn = db.getConnection(); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Admin WHERE aId="+ id);) {
                while (rs.next()) {
                    st = new Admin();
                    st.setaId(rs.getInt("aId"));
                    st.setaName(rs.getString("aName"));
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
          
     public List<Admin> getAdmin() {
        List<Admin> Admin = new ArrayList<>();
         try {
             DBConfig db =  DBConfig.getConn();
            try (Connection conn = db.getConnection(); 
                    Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Admin");) {
                while (rs.next()) {
                    Admin st = new Admin();
                   //st = new Technicians();
                           st.setaId(rs.getInt("aId"));
                    st.setaName(rs.getString("aName"));
                    st.setNic(rs.getString("nic"));
                    st.setPhoneNumber(rs.getString("phoneNumber"));
                    st.setEmail(rs.getString("email"));
                    st.setUiId(rs.getInt("uiId"));
                    Admin.add(st);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }

        return Admin;
    }

}
