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
import resources.Model.Login;
import resources.Model.UserInformation;
import com.fasterxml.jackson.core.JsonProcessingException;
/**
 *
 * @author induwara
 */
public class LoginDataAccess {
    
    public LoginDataAccess() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (Exception e) {
        }
    }
   public UserInformation login(Login login) throws SQLException, JsonProcessingException {
        UserInformation user = null;
        DBConfig db =  DBConfig.getConn();
        try (Connection conn = db.getConnection(); 
                Statement stmt = conn.createStatement(); ){
                String userName = login.getUserName();
                String password = login.getPassword();
                String query = "SELECT COUNT(*) AS count FROM userinformation WHERE email= '"+ userName + "' and password = '"+ password +"' ;";
                ResultSet rs = stmt.executeQuery(query );
            if (rs.next()) {
                int count = rs.getInt("count");
                boolean hasRecords = count > 0;
                if (hasRecords) {
                    user = new UserInformation();
                    try (Connection conn1 = db.getConnection(); 
                        Statement stmt1 = conn1.createStatement(); ){
                            String check = "SELECT * FROM userinformation WHERE email= '"+ userName + "' and password = '"+ password +"' ;";
                            ResultSet r = stmt1.executeQuery(check );
                            //infoMapper.setUserType( r.getString("userType"));
                            while (r.next()) {
                                user.setuId(r.getInt("uId"));
                                user.setUserName(r.getString("userName"));
                                user.setEmail( r.getString("email"));
                                user.setrId(r.getInt("rId"));
                            }
                    } catch (SQLException e) {
                        System.err.print(e);
                        throw e;
                    }
                }else {
                    System.out.println("Invalid Login");
                }
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.print(e);
            throw e;
        }
        return user;
    }
  }
