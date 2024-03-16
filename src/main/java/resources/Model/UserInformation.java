/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.Model;

/**
 *
 * @author induwara
 */
public class UserInformation {
    
    private int uId;
    private String userName;
    private String password;
    private String email;
    private int rId;
    
     public UserInformation(){
        
    }

    public UserInformation(int uId, String userName, String password, String email, int rId) {
        this.uId = uId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.rId = rId;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    
}
