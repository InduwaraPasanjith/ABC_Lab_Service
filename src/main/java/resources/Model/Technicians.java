/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources.Model;

/**
 *
 * @author induwara
 */
public class Technicians {
    
    private int tId;
    private String tName;
    private String nic;
    private String phoneNumber;
    private String email;
    private int uiId;
    
    public Technicians(){
        
    }

    public Technicians(int tId, String tName, String nic, String phoneNumber, String email, int uiId) {
        this.tId = tId;
        this.tName = tName;
        this.nic = nic;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.uiId = uiId;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUiId() {
        return uiId;
    }

    public void setUiId(int uiId) {
        this.uiId = uiId;
    }
    
}
